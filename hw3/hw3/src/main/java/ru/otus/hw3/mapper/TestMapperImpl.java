package ru.otus.hw3.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw3.domain.Task;
import ru.otus.hw3.domain.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class TestMapperImpl implements TestMapper {

    private final TaskMapper taskMapper;

    public TestMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public Test map(File file) {
        Test test;
        try (Scanner scanner = new Scanner(file)) {
            List<Task> tasks = new ArrayList<>();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                tasks.add(taskMapper.map(scanner.nextLine()));
            }
            test = new Test(tasks);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return test;
    }
}
