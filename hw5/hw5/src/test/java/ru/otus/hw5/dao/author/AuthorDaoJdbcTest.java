package ru.otus.hw5.dao.author;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.hw5.domain.Author;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JdbcTest
@Import(AuthorDaoJdbc.class)
class AuthorDaoJdbcTest {


    @Autowired
    private AuthorDaoJdbc dao;

    @Test
    void getAuthors() {
        var authors = dao.getAll();

        assertThat(authors.size()).isEqualTo(2);
    }

    @Test
    void getAuthorById() {
        var expectedAuthor = new Author(1, "Александр", "Пушкин");
        var author = dao.getById(1);

        assertThat(expectedAuthor).isEqualTo(author);
    }

    @Test
    void insertAuthor_getById_equals() {
        var expectedAuthor = new Author(3, "Сергей", "Есенин");
        dao.insert(new Author(3, "Сергей", "Есенин"));

        var author = dao.getById(3);

        assertThat(expectedAuthor).isEqualTo(author);
    }

}