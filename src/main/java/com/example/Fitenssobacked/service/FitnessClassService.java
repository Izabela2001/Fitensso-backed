package com.example.Fitenssobacked.service;

import com.example.Fitenssobacked.model.FitnessClass;
import com.example.Fitenssobacked.repository.FitnessClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FitnessClassService {
    private final FitnessClassRepository fitnessClassRepository;

    @Autowired
    public FitnessClassService(FitnessClassRepository fitnessClassRepository) {
        this.fitnessClassRepository = fitnessClassRepository;
    }
    public List<FitnessClass> getFitnessClassesInTimeframeWithAvailablePlaces(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return fitnessClassRepository.findFitnessClassesInTimeframeWithAvailablePlaces(startDateTime, endDateTime);
    }
}
