package ru.otus.hw2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.otus.hw2.config.AppConfig;
import ru.otus.hw2.domain.Test;
import ru.otus.hw2.mapper.TestMapper;
import ru.otus.hw2.utils.FileUtils;

import java.io.File;
import java.io.IOException;

@Repository
public class TestDaoImpl implements TestDao {

    private final AppConfig appConfig;

    private final TestMapper testMapper;

    @Autowired
    public TestDaoImpl(AppConfig appConfig, TestMapper testMapper) {
        this.appConfig = appConfig;
        this.testMapper = testMapper;
    }

    public Test getTest() {
        try {
            File file = FileUtils.getFile(appConfig.getPath());
            return testMapper.map(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
