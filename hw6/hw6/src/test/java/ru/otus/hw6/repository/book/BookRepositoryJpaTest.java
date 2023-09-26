package ru.otus.hw6.repository.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Genre;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Import(BookRepositoryJpa.class)
class BookRepositoryJpaTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private TestEntityManager em;

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
        var authors = repository.getAll();

        assertThat(authors.size()).isEqualTo(3);
    }

    @Test
    void getById() {
        var expectedBook = em.find(Book.class, 1);
        var book = repository.getById(1);

        assertThat(expectedBook).isEqualTo(book);
    }

    @Test
    void insert() {
        var expectedBook = em.find(Book.class, 1);
        repository.insert(expectedBook);

        var book = repository.getById(1);

        assertThat(expectedBook).isEqualTo(book);
    }

}