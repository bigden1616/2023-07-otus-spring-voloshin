package ru.otus.hw5.domain;

import lombok.NonNull;

public record Author(long id, @NonNull String firstName, @NonNull String lastName) {
}
