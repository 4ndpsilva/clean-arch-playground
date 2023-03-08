package com.github.cleanarchdemo.infrastructure.repository.jdbc.dao;

import com.github.cleanarchdemo.domain.entity.Registration;
import com.github.cleanarchdemo.domain.repository.LoadRegistrationRepository;
import com.github.cleanarchdemo.domain.vo.Cpf;
import com.github.cleanarchdemo.domain.vo.Email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistrationDAO implements LoadRegistrationRepository {
    private Connection connection;

    public RegistrationDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public Registration findByRegistrationNumber(String cpf) {
        try{
            PreparedStatement pstmt = connection.prepareStatement("SELECT * from tb_registration WHERE REGISTRATION_NUMBER = ?");
            pstmt.setString(1, cpf);
            ResultSet result = pstmt.executeQuery();
            Registration registration = null;

            if(result.next()){
                registration = new Registration();
                registration.setName(result.getString("NAME"));
                registration.setBirthDate(result.getDate("BIRTH_DATE").toLocalDate());
                registration.setRegistrationNumber(new Cpf(result.getString("REGISTRATION_NUMBER")));
                registration.setEmail(new Email(result.getString("EMAIL")));
                registration.setRegistrationAt(result.getDate("REGISTRATION_AT").toLocalDate());
            }

            return registration;
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}