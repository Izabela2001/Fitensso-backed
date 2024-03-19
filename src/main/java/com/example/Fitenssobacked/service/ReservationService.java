package com.example.Fitenssobacked.service;

import com.example.Fitenssobacked.model.Reservation;
import com.example.Fitenssobacked.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

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



}
