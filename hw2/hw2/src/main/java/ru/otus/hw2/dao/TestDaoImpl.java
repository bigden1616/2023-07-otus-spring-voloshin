package ru.otus.hw2.dao;

import org.springframework.stereotype.Component;
import ru.otus.hw2.config.AppConfig;
import ru.otus.hw2.domain.Test;
import ru.otus.hw2.mapper.TestMapper;
import ru.otus.hw2.utils.FileUtils;

import java.io.File;
import java.io.IOException;

@Component
public class TestDaoImpl implements TestDao {

    private final AppConfig appConfig;

    private final TestMapper testMapper;

    public TestDaoImpl(AppConfig appConfig, TestMapper testMapper) {
        this.appConfig = appConfig;
        this.testMapper = testMapper;
    }

    @Override
    public Test getTest() {
        try {
            File file = FileUtils.getFile(appConfig.getPath());
            return testMapper.map(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
