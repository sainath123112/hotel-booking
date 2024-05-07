package com.sainath.hotelbookingsystem.userservice.service;

import com.sainath.hotelbookingsystem.userservice.dto.UserCustomerRegDto;
import com.sainath.hotelbookingsystem.userservice.dto.UserCustomerResDto;
import com.sainath.hotelbookingsystem.userservice.entity.User;
import com.sainath.hotelbookingsystem.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean checkUserExists(String email, String role) {
        return userRepository.existsByEmailAndRole(email, role);
    }
    public UserCustomerResDto registerCustomer(UserCustomerRegDto userCustomerRegDto) {
        User user = new User();
        user.setFirst_name(convertToCamelCase(userCustomerRegDto.getFirst_name()));
        user.setLast_name(convertToCamelCase(userCustomerRegDto.getLast_name()));
        user.setEmail(userCustomerRegDto.getEmail());
        user.setPassword_hash(passwordEncoder.encode(userCustomerRegDto.getPassword()));
        user.setRole("CUSTOMER");
        user.setCreated_at(new Timestamp(new Date().getTime()));
        user.setUpdated_at(new Timestamp(new Date().getTime()));
        userRepository.save(user);
        UserCustomerResDto userCustomerResDto = new UserCustomerResDto();
        userCustomerResDto.setUser_id(user.getId());
        userCustomerResDto.setMessage("Customer Registered Successfully");
        userCustomerResDto.setStatus(true);
        return userCustomerResDto;
    }

    public UserCustomerResDto registerManager(UserCustomerRegDto userCustomerRegDto) {
        User user = new User();
        user.setFirst_name(convertToCamelCase(userCustomerRegDto.getFirst_name()));
        user.setLast_name(convertToCamelCase(userCustomerRegDto.getLast_name()));
        user.setEmail(userCustomerRegDto.getEmail());
        user.setPassword_hash(passwordEncoder.encode(userCustomerRegDto.getPassword()));
        user.setRole("MANAGER");
        user.setCreated_at(new Timestamp(new Date().getTime()));
        user.setUpdated_at(new Timestamp(new Date().getTime()));
        userRepository.save(user);
        UserCustomerResDto userCustomerResDto = new UserCustomerResDto();
        userCustomerResDto.setUser_id(user.getId());
        userCustomerResDto.setMessage("Customer Registered Successfully");
        userCustomerResDto.setStatus(true);
        return userCustomerResDto;
    }


    private String convertToCamelCase(String str) {
        String []strArray = str.split(" ");
        StringBuilder result = new StringBuilder(str.length());
        for( String word : strArray) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }        }

        return result.toString().trim();
    }
}
