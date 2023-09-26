package ru.otus.hw6.service.book;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.otus.hw6.repository.book.BookRepository;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.service.author.AuthorService;
import ru.otus.hw6.service.genre.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookServiceImpl implements BookService {

    private final BookRepository bookDao;

    private final GenreService genreService;

    private final AuthorService authorService;

    @Transactional
    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Transactional
    @Override
    public Book getBook(long id) {
        return bookDao.getById(id);
    }

    @Transactional
    @Override
    public Book addBook(String title, long authorId, long genreId) {
        var author = authorService.getAuthor(authorId);
        var genre = genreService.getGenre(genreId);
        var book = new Book(0, title, author, genre);
        var id = bookDao.insert(book);
        return bookDao.getById(id);
    }

    @Transactional
    @Override
    public Book modifyBook(long id, String newName, long authorId, long genreId) {
        var newAuthor = authorService.getAuthor(authorId);
        var newGenre = genreService.getGenre(genreId);
        var book = new Book(id, newName, newAuthor, newGenre);
        bookDao.update(book);
        return bookDao.getById(id);
    }

    @Transactional
    @Override
    public void deleteBook(long id) {
        bookDao.delete(id);
    }
}
