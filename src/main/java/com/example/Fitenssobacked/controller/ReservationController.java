package com.example.Fitenssobacked.controller;

import com.example.Fitenssobacked.model.Reservation;
import com.example.Fitenssobacked.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
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
}
