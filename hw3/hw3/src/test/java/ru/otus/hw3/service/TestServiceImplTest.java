package ru.otus.hw3.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.hw3.domain.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class TestServiceImplTest {

    @org.junit.jupiter.api.Test
    public void test() {
        var testService = mock(TestService.class);
        Test test = new Test(new ArrayList<>());
        Mockito.when(testService.getTest()).thenReturn(test);

        var testEx = testService.getTest();

        assertThat(test).isEqualTo(testEx);
    }

}