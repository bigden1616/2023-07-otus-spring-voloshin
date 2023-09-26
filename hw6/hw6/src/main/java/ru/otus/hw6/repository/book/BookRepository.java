package ru.otus.hw6.repository.book;

import ru.otus.hw6.domain.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAll();

    Book getById(long id);

    long insert(Book book);

    void update(Book book);

    void delete(long id);
}
