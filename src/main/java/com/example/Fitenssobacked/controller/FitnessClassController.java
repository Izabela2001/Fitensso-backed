package com.example.Fitenssobacked.controller;

import com.example.Fitenssobacked.service.FitnessClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fitness-classes")
public class FitnessClassController {
    private final FitnessClassService fitnessClassService;

    @Autowired
    public FitnessClassController(FitnessClassService fitnessClassService) {
        this.fitnessClassService = fitnessClassService;
    }
}
