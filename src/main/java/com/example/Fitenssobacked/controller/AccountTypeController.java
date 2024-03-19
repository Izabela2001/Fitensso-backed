package com.example.Fitenssobacked.controller;

import com.example.Fitenssobacked.model.AccountType;
import com.example.Fitenssobacked.service.AccountTypeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account-types")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountTypeController {

    @Autowired
    private AccountTypeService accountTypeService;

    @PostMapping
    @Transactional
    public AccountType createAccountType(@RequestBody AccountType accountType) {

        return accountTypeService.createAccountType(accountType);
    }
}
