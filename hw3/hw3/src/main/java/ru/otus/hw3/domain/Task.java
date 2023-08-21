package ru.otus.hw3.domain;

import java.util.List;

public record Task(Question question, List<Answer> answers, boolean isMultiChoice) {
}
