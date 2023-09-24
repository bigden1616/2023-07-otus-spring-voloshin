package ru.otus.hw6.service.genre;

import ru.otus.hw6.domain.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenres();

    Genre addGenre(String name);

    Genre getGenre(long id);
}
