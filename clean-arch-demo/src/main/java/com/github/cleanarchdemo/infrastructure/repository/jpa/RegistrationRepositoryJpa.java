package com.github.cleanarchdemo.infrastructure.repository.jpa;

import com.github.cleanarchdemo.domain.entity.Registration;
import com.github.cleanarchdemo.domain.repository.LoadRegistrationRepository;
import com.github.cleanarchdemo.domain.vo.Cpf;
import com.github.cleanarchdemo.domain.vo.Email;
import com.github.cleanarchdemo.infrastructure.repository.jpa.entity.RegistrationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class RegistrationRepositoryJpa implements LoadRegistrationRepository{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Registration findByRegistrationNumber(String cpf){
        try{
            TypedQuery<RegistrationEntity> query = manager.createQuery("SELECT r FROM RegistrationEntity r WHERE r.registrationNumber = :cpf", RegistrationEntity.class);
            query.setParameter("cpf", cpf);
            RegistrationEntity entity = query.getSingleResult();
            Registration r = new Registration();
            r.setName(entity.getName());
            r.setBirthDate(entity.getBirthDate());
            r.setRegistrationNumber(new Cpf(entity.getRegistrationNumber()));
            r.setEmail(new Email(entity.getEmail()));
            r.setRegistrationAt(entity.getRegistrationAt());
            return r;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}