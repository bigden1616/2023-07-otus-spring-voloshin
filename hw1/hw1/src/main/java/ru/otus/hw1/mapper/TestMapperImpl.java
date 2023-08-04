package ru.otus.hw1.mapper;

import ru.otus.hw1.domain.Answer;
import ru.otus.hw1.domain.Question;
import ru.otus.hw1.domain.Task;
import ru.otus.hw1.domain.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestMapperImpl implements TestMapper {
    @Override
    public Test map(File file) {
        Test test;
        try (Scanner scanner = new Scanner(file)) {
            List<Task> tasks = new ArrayList<>();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                tasks.add(getTaskFromLine(scanner.nextLine()));
            }
            test = new Test(tasks);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return test;
    }

    private Task getTaskFromLine(String line) {
        String[] elements = line.split(",");
        Question question = new Question(elements[0]);
        Answer answer = new Answer(List.of(Arrays.copyOfRange(elements, 1, 5)));

        return new Task(question, answer);
    }
}
