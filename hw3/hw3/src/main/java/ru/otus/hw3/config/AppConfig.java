package ru.otus.hw3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test.csv")
public class AppConfig {

    private final String path;

    private final String fileName;

    public AppConfig(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }
}
