package com.github.cleanarchdemo.infrastructure.adapter;

import com.github.cleanarchdemo.application.contract.Storage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalStorageAdapter implements Storage {
    @Override
    public void store(String fileName, String path, String content) {
        try{
            Path pathObj = Paths.get(path + "" + fileName);
            Files.write(pathObj, content.getBytes());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}