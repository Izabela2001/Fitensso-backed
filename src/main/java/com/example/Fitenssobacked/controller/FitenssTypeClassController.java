package com.example.Fitenssobacked.controller;

import com.example.Fitenssobacked.service.FitenssTypeClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fitenss-type-classes")
public class FitenssTypeClassController {
    private final FitenssTypeClassService fitenssTypeClassService;

    @Autowired
    public FitenssTypeClassController(FitenssTypeClassService fitenssTypeClassService) {
        this.fitenssTypeClassService = fitenssTypeClassService;
    }
}
