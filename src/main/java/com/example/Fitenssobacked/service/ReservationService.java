package com.example.Fitenssobacked.service;

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

    public ResponseEntity<String> addReservation(Long userId, Long fitnessClassId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<FitnessClass> optionalFitnessClass = fitnessClassRepository.findById(fitnessClassId);

        if (optionalUser.isPresent() && optionalFitnessClass.isPresent()) {
            User user = optionalUser.get();
            FitnessClass fitnessClass = optionalFitnessClass.get();

            if (fitnessClass.getActivePlace() < fitnessClass.getMaxPlace()) {
                // Pobierz bieżącą datę i godzinę z serwera
                LocalDateTime currentDateTime = LocalDateTime.now();

                // Jeśli jest dostępne miejsce, zapisz rezerwację
                Reservation reservation = new Reservation();
                reservation.setUser(user);
                reservation.setFitnessClass(fitnessClass);
                reservation.setDataReservation(currentDateTime);
                reservation.setIsPurchased(true);
                reservationRepository.save(reservation);
                return new ResponseEntity<>("Rezerwacja została dodana.", HttpStatus.OK);
            } else {
                // Jeśli nie ma dostępnego miejsca, zwróć odpowiedni komunikat
                return new ResponseEntity<>("Brak miejsc.", HttpStatus.BAD_REQUEST);
            }
        } else {
            // Jeśli użytkownik lub zajęcia nie istnieją, zwróć odpowiedni komunikat
            return new ResponseEntity<>("Użytkownik lub zajęcia nie znalezione.", HttpStatus.NOT_FOUND);
        }
    }
}


