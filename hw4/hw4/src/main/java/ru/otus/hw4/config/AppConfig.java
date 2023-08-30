package ru.otus.hw4.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test.csv")
@RequiredArgsConstructor
public class AppConfig {

    @Getter
    private final String path;

    @Getter
    private final String fileName;
}
