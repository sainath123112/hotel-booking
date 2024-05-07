package com.sainath.hotelbookingsystem.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Getter @Setter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String first_name;
    private String last_name;
    private String email;
    private String password_hash;
    private String role;
    private Timestamp created_at;
    private Timestamp updated_at;


}
