package ru.otus.hw6.domain;

import lombok.NonNull;

public record Genre(long id, @NonNull String name) {
}
