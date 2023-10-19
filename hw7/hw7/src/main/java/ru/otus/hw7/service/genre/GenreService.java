package ru.otus.hw7.service.genre;

import ru.otus.hw7.domain.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenres();

    Genre addGenre(String name);

    Genre getGenre(long id);
}
