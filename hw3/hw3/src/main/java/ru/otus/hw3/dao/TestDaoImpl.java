package ru.otus.hw3.dao;

import org.springframework.stereotype.Component;
import ru.otus.hw3.config.AppConfig;
import ru.otus.hw3.config.file.FileProvider;
import ru.otus.hw3.config.localization.LocaleProvider;
import ru.otus.hw3.domain.Test;
import ru.otus.hw3.mapper.TestMapper;
import ru.otus.hw3.config.file.FileProviderImpl;

import java.io.IOException;

@Component
public class TestDaoImpl implements TestDao {

    private final AppConfig appConfig;

    private final TestMapper testMapper;

    private final LocaleProvider localeProvider;

    private final FileProvider fileProvider;

    public TestDaoImpl(AppConfig appConfig, TestMapper testMapper, LocaleProvider localeProvider, FileProvider fileProvider) {
        this.appConfig = appConfig;
        this.testMapper = testMapper;
        this.localeProvider = localeProvider;
        this.fileProvider = fileProvider;
    }

    @Override
    public Test getTest() {
        try {
            var lang = localeProvider.getCurrent().getLanguage();
            var file = fileProvider.getFile(appConfig.getPath() + "/" + lang + "/" + appConfig.getFileName());
            return testMapper.map(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
