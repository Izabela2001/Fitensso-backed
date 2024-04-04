package com.example.Fitenssobacked.service;

import com.example.Fitenssobacked.dtos.ReservationDto;
import com.example.Fitenssobacked.model.FitnessClass;
import com.example.Fitenssobacked.model.Reservation;
import com.example.Fitenssobacked.repository.FitnessClassRepository;
import com.example.Fitenssobacked.repository.ReservationRepository;
import com.example.Fitenssobacked.repository.UserRepository;
import com.example.Fitenssobacked.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@RequestMapping("api/v1/reservations")
@CrossOrigin(origins = "http://localhost:3000" )
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final FitnessClassRepository fitnessClassRepository;

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //all reservation
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    //all reservation accepted
    public List<Reservation> getAcceptedReservations() {
        return reservationRepository.findByIsPurchasedTrue();
    }

    //all reservation not accepted
    public List<Reservation> getNotAcceptedReservations(){
        return reservationRepository.findByIsPurchasedFalse();
    }
    //all reservation user accepted
    public List<Reservation> getAcceptedReservationsByUserId(Long userId) {
        return reservationRepository.findByUserIdAndIsPurchasedTrue(userId);
    }

    //all reservation user not-accepted
    public List<Reservation> getNotAcceptedReservationByUserId(Long userId){
        return reservationRepository.findByUserIdAndIsPurchasedFalse(userId);
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
    // dodawanie reservacji
    public ResponseEntity<String> addReservation(ReservationDto reservationDto) {
        Long userId = reservationDto.getUser();
        Long fitnessClassId = reservationDto.getFitnessClass();

        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<FitnessClass> optionalFitnessClass = fitnessClassRepository.findById(fitnessClassId);

        if (optionalUser.isPresent() && optionalFitnessClass.isPresent()) {
            User user = optionalUser.get();
            FitnessClass fitnessClass = optionalFitnessClass.get();

            if (fitnessClass.getActivePlace() < fitnessClass.getMaxPlace()) {
                LocalDateTime currentDateTime = LocalDateTime.now();
                Reservation reservation = Reservation.builder()
                        .dataReservation(currentDateTime)
                        .user(user)
                        .fitnessClass(fitnessClass)
                        .isPurchased(false) // ustawienie isPurchased na false
                        .build();

                // Zapisz rezerwację
                reservationRepository.save(reservation);

                return new ResponseEntity<>("Rezerwacja została dodana.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Brak miejsc.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Użytkownik lub zajęcia nie znalezione.", HttpStatus.NOT_FOUND);
        }
    }

}


