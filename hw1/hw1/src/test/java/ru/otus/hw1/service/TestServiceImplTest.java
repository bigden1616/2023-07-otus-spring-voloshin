package ru.otus.hw1.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ru.otus.hw1.domain.Answer;
import ru.otus.hw1.domain.Question;
import ru.otus.hw1.domain.Task;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceImplTest {

    @Mock
    TestService testService;

    @Test
    @Ignore("Разобраться с проблемой")
    public void getTest() {
        Task task = new Task(new Question("Hello"), new Answer(new ArrayList<>()));
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        ru.otus.hw1.domain.Test test = new ru.otus.hw1.domain.Test(taskList);
        Mockito.when(testService.getTest()).thenReturn(test);

        ru.otus.hw1.domain.Test exp = testService.getTest();

        Assert.assertEquals(exp, task);
        Mockito.verify(testService).getTest();
    }
}