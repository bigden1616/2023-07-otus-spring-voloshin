package ru.otus.hw8.service.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw8.domain.Book;
import ru.otus.hw8.repository.book.BookRepository;
import ru.otus.hw8.service.author.AuthorService;
import ru.otus.hw8.service.genre.GenreService;

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
    public Book getBook(String id) {
        return bookDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Book addBook(String title, String authorId, String genreId) {
        var author = authorService.getAuthor(authorId);
        var genre = genreService.getGenre(genreId);
        var book = new Book(title, author, genre);
        return bookDao.save(book);
    }

    @Transactional
    @Override
    public Book modifyBook(String id, String newName, String authorId, String genreId) {
        var newAuthor = authorService.getAuthor(authorId);
        var newGenre = genreService.getGenre(genreId);
        var book = new Book(id, newName, newAuthor, newGenre);
        return bookDao.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookDao.deleteById(id);
    }
}
