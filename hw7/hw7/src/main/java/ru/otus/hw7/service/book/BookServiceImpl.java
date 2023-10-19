package ru.otus.hw7.service.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw7.domain.Book;
import ru.otus.hw7.repository.book.BookRepository;
import ru.otus.hw7.service.author.AuthorService;
import ru.otus.hw7.service.genre.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookServiceImpl implements BookService {

    private final BookRepository bookDao;

    private final GenreService genreService;

    private final AuthorService authorService;

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Book getBook(long id) {
        return bookDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Book addBook(String title, long authorId, long genreId) {
        var author = authorService.getAuthor(authorId);
        var genre = genreService.getGenre(genreId);
        var book = new Book(0, title, author, genre);
        return bookDao.save(book);
    }

    @Transactional
    @Override
    public Book modifyBook(long id, String newName, long authorId, long genreId) {
        var newAuthor = authorService.getAuthor(authorId);
        var newGenre = genreService.getGenre(genreId);
        var book = new Book(id, newName, newAuthor, newGenre);
        return bookDao.save(book);
    }

    @Override
    public void deleteBook(long id) {
        bookDao.deleteById(id);
    }
}
