package com.example.Fitenssobacked.repository;

import com.example.Fitenssobacked.model.FitnessClass;
import com.example.Fitenssobacked.model.Reservation;
import com.example.Fitenssobacked.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByIsPurchasedTrue();
    List<Reservation> findByIsPurchasedFalse();
    List<Reservation> findByUserIdAndIsPurchasedTrue(Long userId);
    List<Reservation> findByUserIdAndIsPurchasedFalse(Long userId);
    boolean existsByFitnessClassId(Long fitnessClassId);
    void deleteByFitnessClassId(Long fitnessClassId);
    List<Reservation> findByUser(User user);
}
