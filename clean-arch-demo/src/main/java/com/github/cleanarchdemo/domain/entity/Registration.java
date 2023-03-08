package com.github.cleanarchdemo.domain.entity;

import com.github.cleanarchdemo.domain.vo.Cpf;
import com.github.cleanarchdemo.domain.vo.Email;

import java.time.LocalDate;

public class Registration {
    private String name;
    private Email email;
    private LocalDate birthDate;
    private Cpf registrationNumber;
    private LocalDate registrationAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Cpf getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Cpf registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getRegistrationAt() {
        return registrationAt;
    }

    public void setRegistrationAt(LocalDate registrationAt) {
        this.registrationAt = registrationAt;
    }
}