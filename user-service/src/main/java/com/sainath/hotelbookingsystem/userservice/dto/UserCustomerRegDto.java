package com.sainath.hotelbookingsystem.userservice.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Getter @Setter
public class UserCustomerRegDto {

    @Size(min = 2, max = 50, message = "Length of first_name should be between 2 to 50")
    @NotNull
    private String first_name;

    @Size(min = 2, max = 50, message = "Length of first_name should be between 2 to 50")
    @NotNull
    private String last_name;

    @Email(message = "Enter valid email")
    private String email;

    @NotNull
    @Size(min = 8, max = 50)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$", message = "password should contain atleast one (Capital letter, Lowercase letter, Symbol, Number) and must size must be greater than 8")
    private String password;

}
