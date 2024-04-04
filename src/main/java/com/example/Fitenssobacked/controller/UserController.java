package com.example.Fitenssobacked.controller;

import com.example.Fitenssobacked.config.AuthenticationRequest;
import com.example.Fitenssobacked.config.AuthenticationResponse;
import com.example.Fitenssobacked.dtos.SignUpDto;
import com.example.Fitenssobacked.dtos.UserDto;
import com.example.Fitenssobacked.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "http://localhost:3000" )
public class UserController {
    private final UserService userService;



    @GetMapping("/id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        UserDto user = userService.findById(id);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/by-email")
    public ResponseEntity<Integer[]> getUserIdByEmail(@RequestParam("email") String email) {
        Integer[] userId = userService.findUserDataByEmail(email);
        return ResponseEntity.ok(userId);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> customer = userService.findAllUsers();
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<UserDto>> findAllEmployee() {
        List<UserDto> employee = userService.findAllEmployee();
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/{id}/details")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable long id) {
        UserDto user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    //add employer
    @PostMapping("/addEmployee")
    public ResponseEntity<UserDto> addEmployee(@RequestBody SignUpDto signUpDto){
        UserDto newEmployee = userService.addEmployee(signUpDto);
        return ResponseEntity.ok(newEmployee);
    }
    //update user
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }


}
