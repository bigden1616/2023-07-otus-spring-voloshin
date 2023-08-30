package ru.otus.hw4.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.hw4.domain.User;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(classes = UserServiceImpl.class)
class UserServiceImplTest {

    @MockBean
    private TestInitializerService testInitializerService;

    @MockBean
    private TestExecutorService testExecutorService;

    @MockBean
    private FinishTestService finishTestService;

    @Autowired
    private UserService userService;

    @Test
    void initializeTest() {
        var test = new ru.otus.hw4.domain.Test(new ArrayList<>());
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