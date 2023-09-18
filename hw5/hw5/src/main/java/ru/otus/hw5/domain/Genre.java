package ru.otus.hw5.domain;

import lombok.NonNull;

public record Genre(long id, @NonNull String name) {
}
