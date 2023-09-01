package ru.otus.hw4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.hw4.config.AppConfig;
import ru.otus.hw4.config.ShellConfig;
import ru.otus.hw4.config.localization.LocaleProviderConfig;

@EnableConfigurationProperties({AppConfig.class, LocaleProviderConfig.class, ShellConfig.class})
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
