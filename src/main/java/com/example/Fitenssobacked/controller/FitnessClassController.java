package com.example.Fitenssobacked.controller;

import com.example.Fitenssobacked.model.FitnessClass;
import com.example.Fitenssobacked.service.FitnessClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/itness-classes")
@CrossOrigin(origins = "http://localhost:3000" )
public class FitnessClassController {
    private final FitnessClassService fitnessClassService;

    @Autowired
    public FitnessClassController(FitnessClassService fitnessClassService) {
        this.fitnessClassService = fitnessClassService;
    }

    @GetMapping("/in-timeframe")
    public ResponseEntity<List<FitnessClass>> getFitnessClassesInTimeframe() {

        LocalDateTime startDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = startDateTime.plusDays(7); // Przykładowo: za tydzień od teraz

        List<FitnessClass> fitnessClasses = fitnessClassService.getFitnessClassesInTimeframeWithAvailablePlaces(startDateTime, endDateTime);

        if (!fitnessClasses.isEmpty()) {
            return new ResponseEntity<>(fitnessClasses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
