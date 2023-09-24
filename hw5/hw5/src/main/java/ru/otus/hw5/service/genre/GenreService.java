package ru.otus.hw5.service.genre;

import ru.otus.hw5.domain.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenres();

    Genre addGenre(String name);

    Genre getGenre(long id);
}
