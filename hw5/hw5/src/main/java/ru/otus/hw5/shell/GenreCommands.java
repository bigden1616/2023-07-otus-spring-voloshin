package ru.otus.hw5.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw5.converter.GenreToStringConverter;
import ru.otus.hw5.converter.GenresToStringConverter;
import ru.otus.hw5.service.genre.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class GenreCommands {

    private final GenreService genreService;

    private final GenreToStringConverter genreToStringConverter;

    private final GenresToStringConverter genresToStringConverter;

    @ShellMethod(value = "Get all genres", key = {"get all genres", "gag"})
    public String getAllGenres() {
        var genres = genreService.getAllGenres();
        return genresToStringConverter.convert(genres);
    }

    @ShellMethod(value = "Add genre", key = {"add genre", "ag"})
    public String addGenre(@ShellOption String name) {
        var genre = genreService.addGenre(name);
        return genreToStringConverter.convert(genre);
    }
}
