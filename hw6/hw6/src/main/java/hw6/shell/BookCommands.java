package hw6.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw5.converter.BookToStringConverter;
import ru.otus.hw5.converter.BooksToStringConverter;
import ru.otus.hw5.service.author.AuthorService;
import ru.otus.hw5.service.book.BookService;
import ru.otus.hw5.service.genre.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class BookCommands {

    private final BookService bookService;

    private final GenreService genreService;

    private final AuthorService authorService;

    private final BookToStringConverter bookToStringConverter;

    private final BooksToStringConverter booksToStringConverter;

    @ShellMethod(value = "All books", key = {"get all books", "gab"})
    public String getAllBooks() {
        var books = bookService.getAllBooks();
        return booksToStringConverter.convert(books);
    }

    @ShellMethod(value = "Get book by id", key = {"get book", "gb"})
    public String getBookById(@ShellOption long bookId) {
        var book = bookService.getBook(bookId);
        return bookToStringConverter.convert(book);
    }

    @ShellMethod(value = "Add book", key = {"add book", "ab"})
    public String addBook(@ShellOption String title, @ShellOption long authorId, @ShellOption long genreId) {
        var author = authorService.getAuthor(authorId);
        var genre = genreService.getGenre(genreId);
        var book = bookService.addBook(title, author, genre);
        return bookToStringConverter.convert(book);
    }

    @ShellMethod(value = "Modify book", key = {"modify book", "mb"})
    public String modifyBook(
            @ShellOption long bookId,
            @ShellOption String title,
            @ShellOption long authorId,
            @ShellOption long genreId
    ) {
        var author = authorService.getAuthor(authorId);
        var genre = genreService.getGenre(genreId);
        var book = bookService.modifyBook(bookId, title, author, genre);
        return bookToStringConverter.convert(book);
    }

    @ShellMethod(value = "Delete book", key = {"delete book", "db"})
    public void deleteBook(@ShellOption long id) {
        bookService.deleteBook(id);
    }
}
