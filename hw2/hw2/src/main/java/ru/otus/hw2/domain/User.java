package ru.otus.hw2.domain;

import java.util.List;

public class User {

    private final String name;

    private final String surname;

    private final Test test;

    private final List<String[]> userAnswers;

    private int correctCount;


    public User(String name, String surname, Test test, List<String[]> userAnswers, int correctCount) {
        this.name = name;
        this.surname = surname;
        this.test = test;
        this.userAnswers = userAnswers;
        this.correctCount = correctCount;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Test getTest() {
        return test;
    }

    public List<String[]> getUserAnswers() {
        return userAnswers;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }
}
