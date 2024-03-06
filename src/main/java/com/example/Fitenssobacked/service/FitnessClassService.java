package com.example.Fitenssobacked.service;

import com.example.Fitenssobacked.repository.FitnessClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitnessClassService {
    private final FitnessClassRepository fitnessClassRepository;

    @Autowired
    public FitnessClassService(FitnessClassRepository fitnessClassRepository) {
        this.fitnessClassRepository = fitnessClassRepository;
    }
}
