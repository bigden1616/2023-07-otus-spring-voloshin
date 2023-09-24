package ru.otus.hw5.dao.book;

import ru.otus.hw5.domain.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAll();

    Book getById(long id);

    long insert(Book book);

    void update(Book book);

    void delete(long id);
}
