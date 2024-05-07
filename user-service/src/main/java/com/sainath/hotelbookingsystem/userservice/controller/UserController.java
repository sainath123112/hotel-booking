package com.sainath.hotelbookingsystem.userservice.controller;
import com.sainath.hotelbookingsystem.userservice.dto.ErrorDto;
import com.sainath.hotelbookingsystem.userservice.dto.UserCustomerRegDto;
import com.sainath.hotelbookingsystem.userservice.repository.UserRepository;
import com.sainath.hotelbookingsystem.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;

    @PostMapping("/register/customer")
    public ResponseEntity<?> signUpCustomer(@Valid @RequestBody UserCustomerRegDto userCustomerRegDto) {
        try {
            if(!userService.checkUserExists(userCustomerRegDto.getEmail(), "CUSTOMER")) {
                return ResponseEntity.ok().body(userService.registerCustomer(userCustomerRegDto));
            }
            else {
                throw new InstanceAlreadyExistsException("User Already Exists!");
            }
        }
        catch (Exception e) {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setError(e.getMessage());
            errorDto.setMessage("User Registration Failed!");
            errorDto.setStatus_code(HttpStatus.BAD_REQUEST.value());
            errorDto.setStatus(false);
            return ResponseEntity.badRequest().body(errorDto);
        }
    }

    @PostMapping("/register/manager")
    public ResponseEntity<?> signUpManager(@RequestBody UserCustomerRegDto userCustomerRegDto) {
        try {
            if(!userService.checkUserExists(userCustomerRegDto.getEmail(), "MANAGER")) {
                return ResponseEntity.ok().body(userService.registerManager(userCustomerRegDto));
            }
            else {
                throw new InstanceAlreadyExistsException("User Already Exists!");
            }
        }
        catch (Exception e) {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setError(e.getMessage());
            errorDto.setMessage("User Registration Failed!");
            errorDto.setStatus_code(HttpStatus.BAD_REQUEST.value());
            errorDto.setStatus(false);
            return ResponseEntity.badRequest().body(errorDto);
        }
    }
}
