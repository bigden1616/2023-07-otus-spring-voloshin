package ru.otus.hw2.service;

import org.springframework.stereotype.Service;
import ru.otus.hw2.domain.Answer;
import ru.otus.hw2.domain.Task;
import ru.otus.hw2.domain.Test;
import ru.otus.hw2.domain.User;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final TestService testService;

    private User user;

    public UserServiceImpl(TestService testService) {
        this.testService = testService;
    }

    @Override
    public void initializeTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String username = scanner.next();

        System.out.print("Enter your surname: ");
        String surname = scanner.next();

        System.out.println("Hello, " + username + " " + surname + "! Let's start the test!");

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
        System.out.println(user.getCorrectCount());
    }

    private void printQuestion(String question) {
        System.out.println("Question:");
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
        System.out.println("Your answer: ");
        HashSet<String> yourAnswers = new HashSet<>(Arrays.asList(scanner.next().split("/")));
        HashSet<String> correctAnswers = new HashSet<>();
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
