package com.example.Fitenssobacked.repository;

import com.example.Fitenssobacked.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByIsPurchasedTrue();
    List<Reservation> findByIsPurchasedFalse();
}
