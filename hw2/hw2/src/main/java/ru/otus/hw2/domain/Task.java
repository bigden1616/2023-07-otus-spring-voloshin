package ru.otus.hw2.domain;

import java.util.List;

public record Task(Question question, List<Answer> answers, boolean isMultiChoice) {
}
