package com.github.cleanarchdemo;

import com.github.cleanarchdemo.application.contract.RegistrationPdfExporter;
import com.github.cleanarchdemo.application.contract.Storage;
import com.github.cleanarchdemo.application.usecase.ExportRegistrationUC;
import com.github.cleanarchdemo.application.usecase.dto.InputDTO;
import com.github.cleanarchdemo.application.usecase.dto.OutputDTO;
import com.github.cleanarchdemo.domain.entity.Registration;
import com.github.cleanarchdemo.domain.repository.LoadRegistrationRepository;
import com.github.cleanarchdemo.domain.vo.Cpf;
import com.github.cleanarchdemo.domain.vo.Email;
import com.github.cleanarchdemo.infrastructure.adapter.ItextPdfAdapter;
import com.github.cleanarchdemo.infrastructure.adapter.LocalStorageAdapter;
import com.github.cleanarchdemo.infrastructure.repository.jdbc.ConnectionFactory;
import com.github.cleanarchdemo.infrastructure.repository.jdbc.dao.RegistrationDAO;
import com.github.cleanarchdemo.infrastructure.repository.jpa.RegistrationRepositoryJpa;
//import com.github.cleanarchdemo.infrastructure.repository.jpa.config.SpringDataConfig;
import com.github.cleanarchdemo.infrastructure.repository.jpa.config.SpringDataConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private LoadRegistrationRepository repository;


    @Override
    public void run(String... args) throws Exception {
        //final LoadRegistrationRepository repository = new RegistrationDAO(ConnectionFactory.getConnection());
        final RegistrationPdfExporter pdfExporter = new ItextPdfAdapter();
        final Storage storage = new LocalStorageAdapter();
        final ExportRegistrationUC exportRegistrationUC = new ExportRegistrationUC(repository, pdfExporter, storage);

        final InputDTO inputDTO = new InputDTO("12345678901", "registration", "tmp");
        final OutputDTO outputDTO = exportRegistrationUC.execute(inputDTO);

        System.out.println(outputDTO.getFullFileName());
        System.out.println(repository.findByRegistrationNumber("35239510890").getName());
    }

    public static void main(String[] args) throws Exception{
        //ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);
        //LoadRegistrationRepository repository = context.getBean(RegistrationRepositoryJpa.class);
        SpringApplication.run(Main.class, args);

        //Registration registration = create();
        //String content = pdfExporter.generate(registration);
        //storage.store("teste.txt", "", content);
    }

    private static Registration create() throws Exception{
        Registration registration = new Registration();
        registration.setName("André P da Silva");
        registration.setBirthDate(LocalDate.of(1985, 5, 12));
        registration.setRegistrationNumber(new Cpf("35239510890"));
        registration.setEmail(new Email("email@provider.com"));
        registration.setRegistrationAt(LocalDate.now());
        return registration;
    }
}