package ru.otus.hw1.service;

import ru.otus.hw1.domain.Task;
import ru.otus.hw1.domain.Test;

import java.util.Scanner;

public class UserServiceImpl implements UserService {

    private final TestService testService;

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
    }

    @Override
    public void finishTest() {
        Test test = testService.getTest();
        for (Task task : test.tasks()) {
            System.out.println("Question:");
            System.out.println(task.question().question());
            System.out.println();
            System.out.println("A: " + task.answer().answers().get(0));
            System.out.println("B: " + task.answer().answers().get(1));
            System.out.println("C: " + task.answer().answers().get(2));
            System.out.println("D: " + task.answer().answers().get(3));
            System.out.println();
        }
    }
}
