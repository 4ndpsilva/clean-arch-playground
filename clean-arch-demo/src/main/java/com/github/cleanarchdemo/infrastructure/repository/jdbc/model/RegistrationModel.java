package com.github.cleanarchdemo.infrastructure.repository.jdbc.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistrationModel {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String registrationNumber;
    private LocalDate registrationAt;
}