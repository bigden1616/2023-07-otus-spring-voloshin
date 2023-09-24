package ru.otus.hw6.dao.author;

import ru.otus.hw6.domain.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> getAll();

    Author getById(long id);

    long insert(Author author);
}
