package com.tiago.microapps.interfaces;

public interface FileService {
    void initializeFile();

    void addContent(String content);

    boolean checkFileContainsContent();

    void clearFileContent();

    void readFromFile();
}
