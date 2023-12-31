package ru.otus.hw7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.util.Set;

public class ConversionConfig {

    @Autowired
    private Set<Converter<?, String>> converters;

    @Bean
    ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(
                converters
        );
        return bean;
    }
}
