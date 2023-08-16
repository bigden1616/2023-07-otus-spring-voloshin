package ru.otus.hw2.service;

import org.springframework.stereotype.Service;
import ru.otus.hw2.dao.TestDao;
import ru.otus.hw2.domain.Test;

@Service
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
