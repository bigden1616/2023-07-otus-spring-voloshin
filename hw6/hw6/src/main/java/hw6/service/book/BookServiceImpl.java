package hw6.service.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.otus.hw5.dao.book.BookDao;
import ru.otus.hw5.domain.Author;
import ru.otus.hw5.domain.Book;
import ru.otus.hw5.domain.Genre;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Override
    public Book getBook(long id) {
        return bookDao.getById(id);
    }

    @Override
    public Book addBook(String title, Author author, Genre genre) {
        var book = new Book(0, title, author, genre);
        var id = bookDao.insert(book);
        return bookDao.getById(id);
    }

    @Override
    public Book modifyBook(long id, String newName, Author newAuthor, Genre newGenre) {
        var book = new Book(id, newName, newAuthor, newGenre);
        bookDao.update(book);
        return bookDao.getById(id);
    }

    @Override
    public void deleteBook(long id) {
        bookDao.delete(id);
    }
}
