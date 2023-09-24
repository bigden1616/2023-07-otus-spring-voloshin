package ru.otus.hw5.dao.author;

import ru.otus.hw5.domain.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> getAll();

    Author getById(long id);

    long insert(Author author);
}
