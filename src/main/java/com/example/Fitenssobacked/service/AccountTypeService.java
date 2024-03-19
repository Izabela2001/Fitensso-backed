package com.example.Fitenssobacked.service;

import com.example.Fitenssobacked.model.AccountType;
import com.example.Fitenssobacked.repository.AccountTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeService {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Transactional
    public AccountType createAccountType(AccountType accountType) {

        return accountTypeRepository.save(accountType);
    }
}