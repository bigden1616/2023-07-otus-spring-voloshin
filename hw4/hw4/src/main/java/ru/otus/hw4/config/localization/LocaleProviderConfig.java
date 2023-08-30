package ru.otus.hw4.config.localization;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties(prefix = "localization")
public class LocaleProviderConfig implements LocaleProvider {

    private final Locale locale;

    public LocaleProviderConfig(String locale) {
        this.locale = Locale.forLanguageTag(locale);
    }

    @Override
    public Locale getCurrent() {
        return locale;
    }
}
