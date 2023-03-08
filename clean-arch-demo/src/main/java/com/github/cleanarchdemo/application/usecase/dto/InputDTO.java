package com.github.cleanarchdemo.application.usecase.dto;

public class InputDTO {
    private String registrationNumber;
    private String fileName;
    private String path;

    public InputDTO(String registrationNumber, String fileName, String path){
        this.registrationNumber = registrationNumber;
        this.fileName = fileName;
        this.path = path;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPath() {
        return path;
    }
}