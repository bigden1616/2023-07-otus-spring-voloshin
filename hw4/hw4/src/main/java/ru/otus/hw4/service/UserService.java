package ru.otus.hw4.service;

import ru.otus.hw4.domain.User;

public interface UserService {

    User initializeTest();

    void runTest();

    void finishTest();
}
