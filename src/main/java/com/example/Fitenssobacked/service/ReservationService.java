package com.example.Fitenssobacked.service;

import com.example.Fitenssobacked.model.Reservation;
import com.example.Fitenssobacked.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //all reservation
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
