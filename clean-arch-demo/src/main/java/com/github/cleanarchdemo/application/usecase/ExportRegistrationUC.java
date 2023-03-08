package com.github.cleanarchdemo.application.usecase;

import com.github.cleanarchdemo.application.contract.RegistrationPdfExporter;
import com.github.cleanarchdemo.application.contract.Storage;
import com.github.cleanarchdemo.application.usecase.dto.InputDTO;
import com.github.cleanarchdemo.application.usecase.dto.OutputDTO;
import com.github.cleanarchdemo.domain.entity.Registration;
import com.github.cleanarchdemo.domain.repository.LoadRegistrationRepository;
import com.github.cleanarchdemo.domain.vo.Cpf;

public class ExportRegistrationUC {
    private LoadRegistrationRepository repository;
    private RegistrationPdfExporter pdfExporter;
    private Storage storage;

    public ExportRegistrationUC(LoadRegistrationRepository repository, RegistrationPdfExporter pdfExporter, Storage storage){
        this.repository = repository;
        this.pdfExporter = pdfExporter;
        this.storage = storage;
    }

    public OutputDTO execute(final InputDTO inputDTO){
        try {
            final Cpf registrationNumber = new Cpf(inputDTO.getRegistrationNumber());
            final Registration registration = repository.findByRegistrationNumber(registrationNumber.value());

            if(registration != null){
                final String fileContent = pdfExporter.generate(registration);
                storage.store(inputDTO.getFileName(), inputDTO.getPath(), fileContent);
                return new OutputDTO(inputDTO.getPath() + "/" +inputDTO.getFileName());
            }

            return new OutputDTO("");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}