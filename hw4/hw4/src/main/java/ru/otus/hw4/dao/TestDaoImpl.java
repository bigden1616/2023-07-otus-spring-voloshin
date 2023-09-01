package ru.otus.hw4.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.hw4.config.AppConfig;
import ru.otus.hw4.config.file.FileProvider;
import ru.otus.hw4.config.localization.LocaleProvider;
import ru.otus.hw4.domain.Test;
import ru.otus.hw4.mapper.TestMapper;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TestDaoImpl implements TestDao {

    private final AppConfig appConfig;

    private final TestMapper testMapper;

    private final LocaleProvider localeProvider;

    private final FileProvider fileProvider;

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
