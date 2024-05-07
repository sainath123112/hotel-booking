package com.sainath.hotelbookingsystem.userservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@RequiredArgsConstructor
@Data
public class UserCustomerResDto {
    private UUID user_id;
    private String message;
    private boolean Status;
}
