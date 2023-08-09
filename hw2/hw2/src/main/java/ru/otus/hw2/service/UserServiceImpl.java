package ru.otus.hw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw2.domain.Task;
import ru.otus.hw2.domain.Test;
import ru.otus.hw2.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@Service
public class UserServiceImpl implements UserService {

    private final TestService testService;

    private User user;

    @Autowired
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
        Scanner scanner = new Scanner(System.in);
        for (Task task : user.getTest().tasks()) {
            System.out.println("Question:");
            System.out.println(task.question().question());
            System.out.println();
            System.out.println("A: " + task.answer().answers().get(0));
            System.out.println("B: " + task.answer().answers().get(1));
            System.out.println("C: " + task.answer().answers().get(2));
            System.out.println("D: " + task.answer().answers().get(3));
            System.out.println();

            System.out.println("Your answer: ");
            String[] answer = scanner.next().split("/");
            if (Arrays.equals(task.answer().correctAnswer(), answer)) {
                user.setCorrectCount(user.getCorrectCount() + 1);
            }
            user.getUserAnswers().add(answer);
            System.out.println();
        }
    }

    @Override
    public void finishTest() {
        System.out.println(user.getCorrectCount());
    }
}
