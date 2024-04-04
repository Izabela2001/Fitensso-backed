package com.example.Fitenssobacked.repository;

import com.example.Fitenssobacked.model.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FitnessClassRepository extends JpaRepository<FitnessClass, Long> {
    @Query("SELECT fc FROM FitnessClass fc WHERE fc.startDate >= ?1 AND fc.endDate <= ?2 AND fc.activePlace < fc.maxPlace")
    List<FitnessClass> findFitnessClassesInTimeframeWithAvailablePlaces(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
