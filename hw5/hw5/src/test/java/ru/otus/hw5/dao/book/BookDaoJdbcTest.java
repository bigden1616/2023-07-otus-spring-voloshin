package ru.otus.hw5.dao.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.hw5.domain.Author;
import ru.otus.hw5.domain.Book;
import ru.otus.hw5.domain.Genre;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JdbcTest
@Import(BookDaoJdbc.class)
class BookDaoJdbcTest {

    @Autowired
    private BookDaoJdbc dao;

    private List<Book> initialBooks;

    @BeforeEach
    void initBooks() {
        initialBooks = List.of(
                new Book(1, "Сказка о царе Салтане",
                        new Author(1, "Александр", "Пушкин"),
                        new Genre(1, "Сказки")),
                new Book(2, "Медный всадник",
                        new Author(1, "Александр", "Пушкин"),
                        new Genre(2, "Стихи")),
                new Book(3, "Чистый код",
                        new Author(2, "Роберт", "Мартин"),
                        new Genre(3, "Техническое"))
        );
    }

    @Test
    void getBooks() {
        var authors = dao.getAll();

        assertThat(authors.size()).isEqualTo(3);
    }

}