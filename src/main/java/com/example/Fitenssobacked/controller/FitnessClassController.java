package com.example.Fitenssobacked.controller;

import com.example.Fitenssobacked.dtos.FitnessClassDto;
import com.example.Fitenssobacked.model.FitnessClass;
import com.example.Fitenssobacked.service.FitnessClassService;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //wyswitelanie zajęć w terminie

    @GetMapping("/active-with-vacancies")
    public ResponseEntity<List<FitnessClass>> getAllActiveClassesWithVacanciesAndInTime() {
        List<FitnessClass> fitnessClasses = fitnessClassService.getAllActiveClassesWithVacanciesAndInTime();
        return new ResponseEntity<>(fitnessClasses, HttpStatus.OK);
    }
 //wys zajeć w terminie ale z pełnymi miejscami
    @GetMapping("/activeFull")
    public ResponseEntity<List<FitnessClass>> getAllClassWithMax(){
        List<FitnessClass> fitnessClasses = fitnessClassService.getAllMaxClass();
        return new ResponseEntity<>(fitnessClasses, HttpStatus.OK);
    }
    //wys zajec po terminie
    @GetMapping("/endDate")
    public ResponseEntity<List<FitnessClass>> getAllEndDate(){
        List<FitnessClass> fitnessClasses = fitnessClassService.getEndDate();
        return new ResponseEntity<>(fitnessClasses, HttpStatus.OK);
    }
    //dodawnaie zajec
    @PostMapping("/addNewClass")
    public ResponseEntity<FitnessClassDto> addFitnessClass(@RequestBody FitnessClassDto fitnessClassDto) {
        FitnessClassDto addedFitnessClass = fitnessClassService.addFitnessClass(fitnessClassDto);
        if (addedFitnessClass != null) {
            return new ResponseEntity<>(addedFitnessClass, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
