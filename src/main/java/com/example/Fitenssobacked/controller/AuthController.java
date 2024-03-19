package com.example.Fitenssobacked.controller;

import com.example.Fitenssobacked.config.AuthenticationRequest;
import com.example.Fitenssobacked.config.AuthenticationResponse;
import com.example.Fitenssobacked.config.RegisterRequest;
import com.example.Fitenssobacked.dtos.SignUpDto;
import com.example.Fitenssobacked.dtos.UserDto;
import com.example.Fitenssobacked.service.AuthService;
import com.example.Fitenssobacked.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
