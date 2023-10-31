package ru.otus.hw8.service.author;

import ru.otus.hw8.domain.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author addAuthor(String firstName, String lastName);

    Author getAuthor(String id);
}
