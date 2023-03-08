package com.github.cleanarchdemo.application.contract;

import com.github.cleanarchdemo.domain.entity.Registration;

public interface RegistrationPdfExporter {
    String generate(Registration registration);
}