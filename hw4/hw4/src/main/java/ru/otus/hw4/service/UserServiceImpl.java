package ru.otus.hw4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw4.domain.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final TestInitializerService testInitializerService;

    private final TestExecutorService testExecutorService;

    private final FinishTestService finishTestService;

    private User user;

    @Override
    public User initializeTest() {
        user = testInitializerService.createUser();
        return user;
    }

    @Override
    public void runTest() {
        testExecutorService.processTest(user);
    }

    @Override
    public void finishTest() {
        finishTestService.finishTest(user);
    }
}
