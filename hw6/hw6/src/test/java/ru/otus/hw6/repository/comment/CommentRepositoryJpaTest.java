package ru.otus.hw6.repository.comment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Comment;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Import(CommentRepositoryJpa.class)
class CommentRepositoryJpaTest {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    void getById() {
        var book = em.find(Book.class, 1);
        var expectedComment = new Comment(1, "Hello", book);

        var result = repository.getById(1);

        assertThat(expectedComment).isEqualTo(result);
    }

    @Test
    void insert() {
        var b = em.find(Book.class, 1);
        var expectedComment = new Comment(1, "Hello", b);
        repository.insert(expectedComment);

        var comment = repository.getById(1);

        assertThat(expectedComment).isEqualTo(comment);
    }

}