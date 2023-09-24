package ru.otus.hw5.dao.genre;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import ru.otus.hw5.domain.Genre;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GenreDaoJdbc implements GenreDao {

    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public List<Genre> getAll() {
        return jdbc.query("select id, name from genre", new GenreMapper());
    }

    @Override
    public Genre getById(long id) {
        return jdbc.queryForObject("select id, name from genre where id=:id", Map.of("id", id), new GenreMapper());
    }

    @Override
    public long insert(Genre genre) {
        var params = new MapSqlParameterSource();
        params.addValue("name", genre.name());

        var keyHolder = new GeneratedKeyHolder();
        jdbc.update("insert into genre (name) values (:name)", params, keyHolder, new String[]{"id"});

        return keyHolder.getKey().longValue();
    }
}
