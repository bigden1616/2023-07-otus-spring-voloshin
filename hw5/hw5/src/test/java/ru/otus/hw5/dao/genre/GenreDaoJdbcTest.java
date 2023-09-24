package ru.otus.hw5.dao.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.hw5.domain.Genre;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JdbcTest
@Import(GenreDaoJdbc.class)
class GenreDaoJdbcTest {

    @Autowired
    private GenreDaoJdbc dao;

    @Test
    void getAuthors() {
        var genres = dao.getAll();

        assertThat(genres.size()).isEqualTo(3);
    }

    @Test
    void getGenreById() {
        var expectedGenre = new Genre(1, "Сказки");
        var genre = dao.getById(1);

        assertThat(expectedGenre).isEqualTo(genre);
    }

    @Test
    void insertGenre_getById_equals() {
        var expectedGenre = new Genre(4, "Фантастика");
        dao.insert(new Genre(4, "Фантастика"));

        var genre = dao.getById(4);

        assertThat(expectedGenre).isEqualTo(genre);
    }

}