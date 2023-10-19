package ru.otus.hw7.service.book;

import ru.otus.hw7.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBook(long id);

    Book addBook(String title, long authorId, long genreId);

    Book modifyBook(long id, String newName, long authorId, long genreId);

    void deleteBook(long id);
}
