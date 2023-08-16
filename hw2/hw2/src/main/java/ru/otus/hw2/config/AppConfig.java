package ru.otus.hw2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    private final String path;

    public AppConfig(@Value("${path.csv}") String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
