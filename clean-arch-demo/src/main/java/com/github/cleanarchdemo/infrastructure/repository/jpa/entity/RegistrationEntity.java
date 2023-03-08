package com.github.cleanarchdemo.infrastructure.repository.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_REGISTRATION")
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name = "REGISTRATION_AT")
    private LocalDate registrationAt;
}