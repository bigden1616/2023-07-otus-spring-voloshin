package ru.otus.hw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.hw3.config.AppConfig;
import ru.otus.hw3.config.localization.LocaleProviderConfig;
import ru.otus.hw3.service.TestRunner;

@EnableConfigurationProperties({AppConfig.class, LocaleProviderConfig.class})
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Main.class, args);
        TestRunner testRunner = ctx.getBean(TestRunner.class);
        testRunner.runTest();
    }
}
