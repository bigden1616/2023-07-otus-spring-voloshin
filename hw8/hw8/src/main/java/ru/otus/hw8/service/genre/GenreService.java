package ru.otus.hw8.service.genre;

import ru.otus.hw8.domain.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenres();

    Genre addGenre(String name);

    Genre getGenre(String id);
}
