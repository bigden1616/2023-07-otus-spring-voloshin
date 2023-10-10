package ru.otus.hw6.repository.genre;

import ru.otus.hw6.domain.Genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> getAll();

    Genre getById(long id);

    long insert(Genre genre);
}
