package com.example.Fitenssobacked.controller;

import com.example.Fitenssobacked.dtos.ReservationDto;
import com.example.Fitenssobacked.model.FitnessClass;
import com.example.Fitenssobacked.model.Reservation;
import com.example.Fitenssobacked.repository.FitnessClassRepository;
import com.example.Fitenssobacked.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservations")
@CrossOrigin(origins = "http://localhost:3000" )
public class ReservationController {

    private final ReservationService reservationService;
    private final FitnessClassRepository fitnessClassRepository;


    //all reservation
    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    //all reservation accepted
    @GetMapping("/accepted")
    public List<Reservation> getAcceptedReservations() {
        return reservationService.getAcceptedReservations();
    }

    //all reservation not accepted
    @GetMapping("/not-accepted")
    public List<Reservation> getNotAcceptedReservations(){
        return reservationService.getNotAcceptedReservations();
    }

    //all reservation user accepted
    @GetMapping("/user/{userId}/accepted")
    public ResponseEntity<List<Reservation>> getAcceptedReservationsByUserId(@PathVariable Long userId) {
        List<Reservation> reservations = reservationService.getAcceptedReservationsByUserId(userId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
    //all reservation user not_accpeted
    @GetMapping("/user/{userId}/not-accepted")
    public ResponseEntity<List<Reservation>> getNotAcceptedReservationByUserId(@PathVariable Long userId){
        List<Reservation> reservations = reservationService.getNotAcceptedReservationByUserId(userId);
        return new ResponseEntity<>(reservations,HttpStatus.OK);
    }
    // accepted reservation
    @PutMapping("/{reservationId}/accept")
    public ResponseEntity<String> acceptReservation(@PathVariable Long reservationId) {
        Optional<Reservation> optionalReservation = reservationService.getReservationById(reservationId);

        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setIsPurchased(true);

            reservationService.saveReservation(reservation);

            // Zwiększ pole activePlace w tabeli FitnessClass
            FitnessClass fitnessClass = reservation.getFitnessClass();
            int activePlace = fitnessClass.getActivePlace() + 1;
            fitnessClass.setActivePlace(activePlace);
            fitnessClassRepository.save(fitnessClass);

            return new ResponseEntity<>("Reservation with ID " + reservationId + " has been accepted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Reservation with ID " + reservationId + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    // accepted all reservation
     @PutMapping("/accept/all")
     public ResponseEntity<String> acceptAllReservations() {
         List<Reservation> reservations = reservationService.getAllReservations();

         if (!reservations.isEmpty()) {
             for (Reservation reservation : reservations) {
                 reservation.setIsPurchased(true);
                 reservationService.saveReservation(reservation);

                 // Zwiększ pole activePlace w tabeli FitnessClass
                 FitnessClass fitnessClass = reservation.getFitnessClass();
                 int activePlace = fitnessClass.getActivePlace() + 1;
                 fitnessClass.setActivePlace(activePlace);
                 fitnessClassRepository.save(fitnessClass);
             }
             return new ResponseEntity<>("All reservations have been accepted.", HttpStatus.OK);
         } else {
             return new ResponseEntity<>("No reservations found.", HttpStatus.NOT_FOUND);
         }
     }

    // dodawanie nowej rezerwacji
     @PostMapping("/add")
     public ResponseEntity<String> addReservation(@RequestBody ReservationDto reservationDto) {
         return reservationService.addReservation(reservationDto);
     }
     //uswanie reserwacji
     @DeleteMapping("/{reservationId}/delete")
     public ResponseEntity<String> deleteReservation(@PathVariable Long reservationId) {
         Optional<Reservation> optionalReservation = reservationService.getReservationById(reservationId);

         if (optionalReservation.isPresent()) {
             Reservation reservation = optionalReservation.get();

             if (reservation.getIsPurchased()) {
                 // Jeśli rezerwacja została zaakceptowana, zmniejsz pole activePlace w tabeli FitnessClass
                 FitnessClass fitnessClass = reservation.getFitnessClass();
                 int activePlace = fitnessClass.getActivePlace() - 1;
                 fitnessClass.setActivePlace(activePlace);
                 fitnessClassRepository.save(fitnessClass);
             }

             reservationService.deleteReservation(reservationId);
             return new ResponseEntity<>("Reservation with ID " + reservationId + " has been deleted.", HttpStatus.OK);
         } else {
             return new ResponseEntity<>("Reservation with ID " + reservationId + " not found.", HttpStatus.NOT_FOUND);
         }
     }

}
