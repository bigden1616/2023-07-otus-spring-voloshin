package ru.otus.hw2.service;

import org.springframework.stereotype.Service;

@Service
public class TestRunnerImpl implements TestRunner {

    private final UserService userService;

    public TestRunnerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void runTest() {
        userService.initializeTest();
        userService.runTest();
        userService.finishTest();
    }
}
