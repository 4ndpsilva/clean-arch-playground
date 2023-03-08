package com.github.cleanarchdemo.domain.vo;

public class Cpf {
    private String cpf;

    public Cpf(String cpf) throws Exception {
        if(!validate(cpf)){
            throw new Exception("CPF não é válido");
        }

        this.cpf = cpf;
    }

    private boolean validate(String cpf) {
        return cpf.length() == 11;
    }

    public String value(){
        return cpf;
    }
}