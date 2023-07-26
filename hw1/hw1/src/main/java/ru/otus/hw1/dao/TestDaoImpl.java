package ru.otus.hw1.dao;

import ru.otus.hw1.domain.Test;
import ru.otus.hw1.mapper.TestMapper;
import ru.otus.hw1.utils.FileUtils;

import java.io.File;
import java.io.IOException;

public class TestDaoImpl implements TestDao {

    private final String path;

    private final TestMapper testMapper;

    public TestDaoImpl(String path, TestMapper testMapper) {
        this.path = path;
        this.testMapper = testMapper;
    }

    public Test getTest() {
        try {
            File file = FileUtils.getFile(path);
            return testMapper.map(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
