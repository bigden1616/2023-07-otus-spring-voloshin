package ru.otus.hw6.repository.author;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.hw6.domain.Author;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Import(AuthorRepositoryJpa.class)
class AuthorRepositoryJpaTest {

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    void getAuthors() {
        var authors = repository.getAll();

        assertThat(authors.size()).isEqualTo(2);
    }

    @Test
    void getAuthorById() {
        var expectedAuthor = em.find(Author.class, 1);
        var author = repository.getById(1);

        assertThat(expectedAuthor).isEqualTo(author);
    }

    @Test
    void insertAuthor() {
        var expectedAuthor = new Author(3, "Сергей", "Есенин");
        repository.insert(expectedAuthor);

        var author = repository.getById(3);

        assertThat(expectedAuthor).isEqualTo(author);
    }
}