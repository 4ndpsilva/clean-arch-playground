package com.github.cleanarchdemo.application.contract;

public interface Storage {
    void store(String fileName, String path, String content);
}