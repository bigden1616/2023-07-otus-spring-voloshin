package ru.otus.hw4.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.boot.TerminalCustomizer;

@ConfigurationProperties(prefix = "test")
public class ShellConfig {

    @Bean
    @ConditionalOnProperty(name = "execution-mode.shell", havingValue = "true", matchIfMissing = false)
    public TerminalCustomizer terminalCustomizerCharset() {
        return builder -> builder.encoding(System.console().charset());
    }
}
