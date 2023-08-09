package ru.otus.hw2.mapper;

import ru.otus.hw2.domain.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;


public class TestMapperImplTest {

    @org.junit.jupiter.api.Test
    public void testReadFromFile() {
        // given
        var testMapper = new TestMapperImpl();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("tasks.csv").getFile());

        // when
        Test test = testMapper.map(file);

        // then
        assertThat(test.tasks().size()).isEqualTo(5);
    }
}