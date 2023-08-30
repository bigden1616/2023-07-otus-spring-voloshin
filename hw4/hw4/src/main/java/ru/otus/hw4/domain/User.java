package ru.otus.hw4.domain;

import java.util.List;

public record User(String name, String surname, Test test, List<String[]> userAnswers) {

    public void addAnswers(String[] answers) {
        userAnswers.add(answers);
    }
}
