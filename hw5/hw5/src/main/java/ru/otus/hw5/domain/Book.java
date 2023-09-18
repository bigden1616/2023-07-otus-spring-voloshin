package ru.otus.hw5.domain;

import lombok.NonNull;

public record Book(long id, @NonNull String title, @NonNull Author author, @NonNull Genre genre) {
}
