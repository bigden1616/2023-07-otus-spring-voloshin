package ru.otus.hw6.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw6.converter.BookToStringConverter;
import ru.otus.hw6.converter.BooksToStringConverter;
import ru.otus.hw6.service.book.BookService;

@ShellComponent
@RequiredArgsConstructor
public class BookCommands {

    private final BookService bookService;

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
        var book = bookService.addBook(title, authorId, genreId);
        return bookToStringConverter.convert(book);
    }

    @ShellMethod(value = "Modify book", key = {"modify book", "mb"})
    public String modifyBook(
            @ShellOption long bookId,
            @ShellOption String title,
            @ShellOption long authorId,
            @ShellOption long genreId
    ) {
        var book = bookService.modifyBook(bookId, title, authorId, genreId);
        return bookToStringConverter.convert(book);
    }

    @ShellMethod(value = "Delete book", key = {"delete book", "db"})
    public void deleteBook(@ShellOption long id) {
        bookService.deleteBook(id);
    }
}
