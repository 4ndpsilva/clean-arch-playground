package com.github.cleanarchdemo.domain.repository;

import com.github.cleanarchdemo.domain.entity.Registration;

public interface LoadRegistrationRepository {
    Registration findByRegistrationNumber(String cpf);
}