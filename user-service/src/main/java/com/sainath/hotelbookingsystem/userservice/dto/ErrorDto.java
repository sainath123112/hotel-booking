package com.sainath.hotelbookingsystem.userservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter
@RequiredArgsConstructor
public class ErrorDto {

    private String error;
    private String message;
    private int status_code;
    private boolean status;

}
