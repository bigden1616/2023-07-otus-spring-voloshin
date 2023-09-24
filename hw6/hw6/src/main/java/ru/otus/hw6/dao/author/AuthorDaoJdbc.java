package ru.otus.hw6.dao.author;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import ru.otus.hw6.domain.Author;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public List<Author> getAll() {
        return jdbc.query("select id, first_name, last_name from authors", new AuthorMapper());
    }

    @Override
    public Author getById(long id) {
        return jdbc.queryForObject("select id, first_name, last_name from authors where id=:id",
                Map.of("id", id), new AuthorMapper()
        );
    }

    @Override
    public long insert(Author author) {
        var params = new MapSqlParameterSource();
        params.addValue("firstName", author.firstName());
        params.addValue("lastName", author.lastName());

        var keyHolder = new GeneratedKeyHolder();
        jdbc.update(
                "insert into authors (first_name, last_name) values (:firstName, :lastName)",
                params,
                keyHolder,
                new String[]{"id"}
        );

        return keyHolder.getKey().longValue();
    }
}