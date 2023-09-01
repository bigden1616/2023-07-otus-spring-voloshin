package ru.otus.hw4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestRunnerImpl implements TestRunner {

    private final UserService userService;

    @Override
    public void runTest() {
        userService.initializeTest();
        userService.runTest();
        userService.finishTest();
    }
}
