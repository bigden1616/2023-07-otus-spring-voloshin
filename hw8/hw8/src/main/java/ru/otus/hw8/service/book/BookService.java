package ru.otus.hw8.service.book;

import ru.otus.hw8.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBook(String id);

    Book addBook(String title, String authorId, String genreId);

    Book modifyBook(String id, String newName, String authorId, String genreId);

    void deleteBook(String id);
}
