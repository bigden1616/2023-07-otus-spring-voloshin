package ru.otus.hw6.service.author;

import ru.otus.hw6.domain.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author addAuthor(String firstName, String lastName);

    Author getAuthor(long id);
}
