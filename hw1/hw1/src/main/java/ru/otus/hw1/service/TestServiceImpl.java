package ru.otus.hw1.service;

import ru.otus.hw1.dao.TestDao;
import ru.otus.hw1.domain.Test;

public class TestServiceImpl implements TestService {

    private final TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Test getTest() {
        return testDao.getTest();
    }
}
