package ru.otus.hw3.dao;

import org.springframework.stereotype.Component;
import ru.otus.hw3.config.AppConfig;
import ru.otus.hw3.config.localization.LocaleProvider;
import ru.otus.hw3.domain.Test;
import ru.otus.hw3.mapper.TestMapper;
import ru.otus.hw3.utils.FileUtils;

import java.io.File;
import java.io.IOException;

@Component
public class TestDaoImpl implements TestDao {

    private final AppConfig appConfig;

    private final TestMapper testMapper;

    private final LocaleProvider localeProvider;

    public TestDaoImpl(AppConfig appConfig, TestMapper testMapper, LocaleProvider localeProvider) {
        this.appConfig = appConfig;
        this.testMapper = testMapper;
        this.localeProvider = localeProvider;
    }

    @Override
    public Test getTest() {
        try {
            var lang = localeProvider.getCurrent().getLanguage();
            File file = FileUtils.getFile(appConfig.getPath() + "/" + lang + "/" + appConfig.getFileName());
            return testMapper.map(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
