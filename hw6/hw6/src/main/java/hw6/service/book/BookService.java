package hw6.service.book;

import ru.otus.hw5.domain.Author;
import ru.otus.hw5.domain.Book;
import ru.otus.hw5.domain.Genre;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBook(long id);

    Book addBook(String title, Author author, Genre genre);

    Book modifyBook(long id, String newName, Author newAuthor, Genre newGenre);

    void deleteBook(long id);
}
