package com.example.Fitenssobacked.repository;

import com.example.Fitenssobacked.model.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessClassRepository extends JpaRepository<FitnessClass, Long> {
}
