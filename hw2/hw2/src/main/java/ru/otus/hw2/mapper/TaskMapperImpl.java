package ru.otus.hw2.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw2.domain.Answer;
import ru.otus.hw2.domain.Question;
import ru.otus.hw2.domain.Task;

import java.util.*;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task map(String line) {
        var elements = line.split(",");
        var question = new Question(elements[0]);
        var answers = Arrays.copyOfRange(elements, 1, 5);
        var correctAnswers = new HashSet<>(Arrays.asList(elements[6].split("/")));

        List<Answer> answerList = new ArrayList<>();
        for (int i = 0; i < answers.length; i++) {
            var answer = new Answer(answers[i], correctAnswers.contains(Integer.toString(i + 1)));
            answerList.add(answer);
        }

        return new Task(question, answerList, Boolean.parseBoolean(elements[5]));
    }
}
