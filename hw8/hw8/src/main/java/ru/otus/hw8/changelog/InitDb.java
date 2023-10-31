package ru.otus.hw8.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import ru.otus.hw8.domain.Author;
import ru.otus.hw8.domain.Book;
import ru.otus.hw8.domain.Comment;
import ru.otus.hw8.domain.Genre;
import ru.otus.hw8.repository.author.AuthorRepository;
import ru.otus.hw8.repository.book.BookRepository;
import ru.otus.hw8.repository.comment.CommentRepository;
import ru.otus.hw8.repository.genre.GenreRepository;

import java.util.List;

@ChangeLog
public class InitDb {

    private List<Author> authors;

    private List<Genre> genres;

    private List<Book> books;

    private List<Comment> comments;

    @ChangeSet(order = "001", id = "dropDb", author = "voloshin", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "initDb", author = "voloshin", runAlways = true)
    public void initDb(GenreRepository genreRepository, AuthorRepository authorRepository, BookRepository bookRepository, CommentRepository commentRepository) {
        createGenres(genreRepository);
        createAuthors(authorRepository);
        createBooks(bookRepository);
        createComments(commentRepository);
    }

    private void createAuthors(AuthorRepository repository) {
        var author1 = repository.save(new Author("Роберт", "Мартин"));
        var author2 = repository.save(new Author("Александр", "Пушкин"));
        authors = List.of(author1, author2);
    }

    private void createGenres(GenreRepository repository) {
        var genre1 = repository.save(new Genre("Сказки"));
        var genre2 = repository.save(new Genre("Стихи"));
        var genre3 = repository.save(new Genre("Техническое"));
        genres = List.of(genre1, genre2, genre3);
    }

    private void createBooks(BookRepository repository) {
        var book1 = repository.save(new Book("Сказка о царе Салтане", authors.get(0), genres.get(0)));
        var book2 = repository.save(new Book("Медный всадник", authors.get(0), genres.get(1)));
        var book3 = repository.save(new Book("Чистый код", authors.get(1), genres.get(2)));
        books = List.of(book1, book2, book3);
    }

    private void createComments(CommentRepository repository) {
        var comment1 = repository.save(new Comment("Hello", books.get(0)));
        var comment2 = repository.save(new Comment("World", books.get(0)));
        var comment3 = repository.save(new Comment("Good Book", books.get(1)));
        comments = List.of(comment1, comment2, comment3);
    }

}
