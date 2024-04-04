package com.example.Fitenssobacked.repository;

import com.example.Fitenssobacked.model.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface FitnessClassRepository extends JpaRepository<FitnessClass, Long> {
    Optional<FitnessClass> findById(long id);
}
