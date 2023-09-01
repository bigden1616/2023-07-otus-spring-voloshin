package ru.otus.hw4.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.hw4.dao.TestDao;

import java.util.ArrayList;

@SpringBootTest
@ContextConfiguration(classes = TestServiceImpl.class)
public class TestServiceImplTest {

    @MockBean
    private TestDao testDao;

    @Autowired
    private TestService testService;

    @Test
    void test() {
        var test = new ru.otus.hw4.domain.Test(new ArrayList<>());
        Mockito.when(testDao.getTest()).thenReturn(test);

        var testEx = testService.getTest();

        verify(testDao).getTest();
        assertThat(test).isEqualTo(testEx);
    }

}