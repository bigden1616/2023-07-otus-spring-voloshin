package ru.otus.hw6.dao.genre;

import ru.otus.hw6.domain.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getAll();

    Genre getById(long id);

    long insert(Genre genre);
}