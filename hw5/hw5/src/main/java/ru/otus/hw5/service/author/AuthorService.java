package ru.otus.hw5.service.author;

import ru.otus.hw5.domain.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author addAuthor(String firstName, String lastName);

    Author getAuthor(long id);
}
