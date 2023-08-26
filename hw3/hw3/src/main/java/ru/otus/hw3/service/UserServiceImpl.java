package ru.otus.hw3.service;

import org.springframework.stereotype.Service;
import ru.otus.hw3.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private final TestInitializerService testInitializerService;

    private final TestExecutorService testExecutorService;

    private final FinishTestService finishTestService;

    private User user;

    public UserServiceImpl(TestInitializerService testInitializerService,
                           TestExecutorService testExecutorService,
                           FinishTestService finishTestService) {
        this.testInitializerService = testInitializerService;
        this.testExecutorService = testExecutorService;
        this.finishTestService = finishTestService;
    }

    @Override
    public void initializeTest() {
        user = testInitializerService.createUser();
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
