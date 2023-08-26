package ru.otus.hw3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.hw3.domain.User;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private TestInitializerService testInitializerService;

    @Mock
    private TestExecutorService testExecutorService;

    @Mock
    private FinishTestService finishTestService;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(testInitializerService, testExecutorService, finishTestService);
    }

    @Test
    void initializeTest() {
        var test = new ru.otus.hw3.domain.Test(new ArrayList<>());
        var user = new User("Vasya", "Ivanov", test, new ArrayList<>());
        when(testInitializerService.createUser()).thenReturn(user);

        userService.initializeTest();

        verify(testInitializerService).createUser();
    }

    @Test
    void runTest() {
        userService.runTest();

        verify(testExecutorService).processTest(any());
    }

    @Test
    void finishTest() {
        userService.finishTest();

        verify(finishTestService).finishTest(any());
    }
}