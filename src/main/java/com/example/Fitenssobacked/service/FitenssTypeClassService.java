package com.example.Fitenssobacked.service;

import com.example.Fitenssobacked.repository.FitenssTypeClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitenssTypeClassService {
    private final FitenssTypeClassRepository fitenssTypeClassRepository;

    @Autowired
    public FitenssTypeClassService(FitenssTypeClassRepository fitenssTypeClassRepository) {
        this.fitenssTypeClassRepository = fitenssTypeClassRepository;
    }
}
