package ru.otus.hw3.service;

import org.springframework.stereotype.Service;
import ru.otus.hw3.domain.Answer;
import ru.otus.hw3.domain.Task;
import ru.otus.hw3.domain.Test;
import ru.otus.hw3.domain.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final TestService testService;

    private final LocalizationService localizationService;

    private User user;

    public UserServiceImpl(TestService testService, LocalizationService localizationService) {
        this.testService = testService;
        this.localizationService = localizationService;
    }

    @Override
    public void initializeTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(localizationService.getMessage("test.name") + " ");
        String username = scanner.next();

        System.out.print(localizationService.getMessage("test.surname") + " ");
        String surname = scanner.next();

        System.out.println(localizationService.getMessage("test.start", username, surname));

        Test test = testService.getTest();
        user = new User(username, surname, test, new ArrayList<>(), 0);
    }

    @Override
    public void runTest() {
        for (Task task : user.getTest().tasks()) {
            printQuestion(task.question().question());
            printAnswers(task.answers());
            printAnswer(task.answers());
        }
    }

    @Override
    public void finishTest() {
        System.out.println(localizationService.getMessage("test.result", user.getCorrectCount()));
    }

    private void printQuestion(String question) {
        System.out.println(localizationService.getMessage("test.question") + " ");
        System.out.println(question);
        System.out.println();
    }

    private void printAnswers(List<Answer> answers) {
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + ": " + answers.get(i).answer());
        }
        System.out.println();
    }

    private void printAnswer(List<Answer> answers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(localizationService.getMessage("test.answer") + " ");
        var yourAnswers = new HashSet<>(Arrays.asList(scanner.next().split("/")));
        var correctAnswers = new HashSet<>();
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).isCorrect()) {
                correctAnswers.add(Integer.toString(i + 1));
            }
        }

        if (correctAnswers.equals(yourAnswers)) {
            user.setCorrectCount(user.getCorrectCount() + 1);
        }
        System.out.println();
    }
}
