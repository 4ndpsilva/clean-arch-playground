package com.github.cleanarchdemo.domain.vo;

public class Email {
    private String email;

    public Email(String email) throws Exception {
        if(!validate(email)){
            throw new Exception("E-mail não é válido");
        }

        this.email = email;
    }

    private boolean validate(String email) {
        return email.contains("@");
    }

    public String value(){
        return email;
    }
}