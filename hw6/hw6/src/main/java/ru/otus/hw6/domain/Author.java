package ru.otus.hw6.domain;

import lombok.NonNull;

public record Author(long id, @NonNull String firstName, @NonNull String lastName) {
}
