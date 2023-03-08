package com.github.cleanarchdemo.application.usecase.dto;

public class OutputDTO {
    private String fullFileName;

    public OutputDTO(String fullFileName){
        this.fullFileName = fullFileName;
    }

    public String getFullFileName() {
        return fullFileName;
    }
}