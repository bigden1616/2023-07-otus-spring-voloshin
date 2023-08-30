package ru.otus.hw4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw4.dao.TestDao;
import ru.otus.hw4.domain.Test;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestDao testDao;

    @Override
    public Test getTest() {
        return testDao.getTest();
    }
}
