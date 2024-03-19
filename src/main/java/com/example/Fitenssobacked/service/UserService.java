package com.example.Fitenssobacked.service;

import com.example.Fitenssobacked.config.JwtService;
import com.example.Fitenssobacked.dtos.CredentialsDto;
import com.example.Fitenssobacked.dtos.SignUpDto;
import com.example.Fitenssobacked.dtos.UserDto;
import com.example.Fitenssobacked.model.AccountType;
import com.example.Fitenssobacked.model.User;
import com.example.Fitenssobacked.exception.AppException;
import com.example.Fitenssobacked.repository.AccountTypeRepository;
import com.example.Fitenssobacked.repository.UserRepository;
import com.example.Fitenssobacked.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AccountTypeRepository accountTypeRepository;


    public UserDto register(SignUpDto signUpDto) {
        String login = signUpDto.getLogin();
        if (userRepository.existsByLogin(login)) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }
        User user = userMapper.signUpToUser(signUpDto);
        String encodedPassword = passwordEncoder.encode(signUpDto.getPassword());
        user.setPassword(encodedPassword);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }



    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public UserDto findById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public UserDto login(CredentialsDto credentialsDto) {
        String login = credentialsDto.getLogin();
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if (passwordEncoder.matches(credentialsDto.getPassword(), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public List<UserDto> findAllUsers() {
        List<User> employees = userRepository.findAllUsers();
        return userMapper.toUserDtoList(employees);
    }
    @Transactional
    public Integer[] findUserDataByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException("User not found for email: " + email, HttpStatus.NOT_FOUND));
        Integer[] userData = {Integer.parseInt(user.getId().toString()), Integer.parseInt(user.getAccountType().getId().toString())};
        return userData;
    }

    //add employee
    @Transactional
    public UserDto addEmployee(SignUpDto signUpDto){
        User employee = userMapper.signUpToUser(signUpDto);
        employee.setAccountType(new AccountType(3l,"Employee"));
        String endocdePassword = passwordEncoder.encode(signUpDto.getPassword());
        employee.setPassword(endocdePassword);
        User saveEmployee = userRepository.save(employee);
        return userMapper.toUserDto(saveEmployee);
    }

    //update user
    @Transactional
    public UserDto updateUser(long id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        if (userDto.getFirstName() != null) {
            existingUser.setFirstName(userDto.getFirstName());
        }
        if (userDto.getLastName() != null) {
            existingUser.setLastName(userDto.getLastName());
        }
        if (userDto.getEmail() != null) {
            existingUser.setEmail(userDto.getEmail());
        }
        if (userDto.getLogin() != null) {
            existingUser.setLogin(userDto.getLogin());
        }
        if (userDto.getPassword() != null) {
            String encodedPassword = passwordEncoder.encode(userDto.getPassword());
            existingUser.setPassword(encodedPassword);
        }
        if (userDto.getPhone() != null) {
            existingUser.setPhone(userDto.getPhone());
        }

        User updatedUser = userRepository.save(existingUser);
        return userMapper.toUserDto(updatedUser);
    }

}




