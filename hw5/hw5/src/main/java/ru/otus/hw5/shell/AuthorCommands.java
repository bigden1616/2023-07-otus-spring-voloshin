package ru.otus.hw5.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw5.converter.AuthorToStringConverter;
import ru.otus.hw5.converter.AuthorsToStringConverter;
import ru.otus.hw5.service.author.AuthorService;

@ShellComponent
@RequiredArgsConstructor
public class AuthorCommands {

    private final AuthorService authorService;

    private final AuthorToStringConverter authorToStringConverter;

    private final AuthorsToStringConverter authorsToStringConverter;

    @ShellMethod(value = "Get all authors", key = {"get all authors", "gaa"})
    public String getAllAuthors() {
        var authors = authorService.getAllAuthors();
        return authorsToStringConverter.convert(authors);
    }

    @ShellMethod(value = "Add author", key = {"add author", "aa"})
    public String addAuthor(@ShellOption String firstName, @ShellOption String lastName) {
        var author = authorService.addAuthor(firstName, lastName);
        return authorToStringConverter.convert(author);
    }
}
