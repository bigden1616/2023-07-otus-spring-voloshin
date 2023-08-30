package ru.otus.hw4.mapper;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;


public class TestMapperImplTest {

    @Test
    public void testReadFromFile() {
        // given
        var taskMapper = new TaskMapperImpl();
        var testMapper = new TestMapperImpl(taskMapper);
        var classLoader = getClass().getClassLoader();
        var file = new File(classLoader.getResource("tasks.csv").getFile());

        // when
        var test = testMapper.map(file);

        // then
        assertThat(test.tasks().size()).isEqualTo(5);
    }
}