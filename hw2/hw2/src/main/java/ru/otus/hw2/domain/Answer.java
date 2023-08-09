package ru.otus.hw2.domain;

import java.util.List;

public record Answer(List<String> answers, boolean isMultiChoice, String[] correctAnswer) {
}
