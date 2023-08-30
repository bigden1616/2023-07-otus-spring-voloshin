package ru.otus.hw4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw4.domain.Answer;
import ru.otus.hw4.domain.Task;
import ru.otus.hw4.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestExecutorServiceImpl implements TestExecutorService {

    private final LocalizationService localizationService;

    private final IOService ioService;

    @Override
    public void processTest(User user) {
        user.test().tasks().forEach(task -> processTask(task, user));
    }

    private void processTask(Task task, User user) {
        printQuestion(task.question().question());
        printAnswers(task.answers());
        printAnswer(user);
    }

    private void printQuestion(String question) {
        var questionTitle = localizationService.getMessage("test.question");
        ioService.outputString(questionTitle);
        ioService.outputString(question);
        ioService.outputEmptyLine();
    }

    private void printAnswers(List<Answer> answers) {
        for (int i = 0; i < answers.size(); i++) {
            var answer = String.format("%d: %s", i + 1, answers.get(i).answer());
            ioService.outputString(answer);
        }
        ioService.outputEmptyLine();
    }

    private void printAnswer(User user) {
        var answerText = localizationService.getMessage("test.answer");
        ioService.outputString(answerText);

        var yourAnswers = ioService.inputWithSplit("/");
        user.addAnswers(yourAnswers);
    }
}
