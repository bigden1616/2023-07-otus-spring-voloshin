package ru.otus.hw6.repository.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.hw6.domain.Genre;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Import(GenreRepositoryJpa.class)
class GenreRepositoryJpaTest {

    @Autowired
    private GenreRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    void getAuthors() {
        var genres = repository.getAll();

        assertThat(genres.size()).isEqualTo(3);
    }

    @Test
    void getGenreById() {
        var expectedGenre = em.find(Genre.class, 1);
        var genre = repository.getById(1);

        assertThat(expectedGenre).isEqualTo(genre);
    }

    @Test
    void insertGenre_getById_equals() {
        var expectedGenre = new Genre(4, "Фантастика");
        repository.insert(expectedGenre);

        var genre = repository.getById(4);

        assertThat(expectedGenre).isEqualTo(genre);
    }

}