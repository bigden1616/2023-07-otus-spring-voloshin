package ru.otus.hw6.repository.author;

import ru.otus.hw6.domain.Author;

import java.util.List;

public interface AuthorRepository {

    List<Author> getAll();

    Author getById(long id);

    long insert(Author author);
}
