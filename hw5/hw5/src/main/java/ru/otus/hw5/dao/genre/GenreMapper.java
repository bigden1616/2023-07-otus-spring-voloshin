package ru.otus.hw5.dao.genre;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.hw5.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        return new Genre(id, name);
    }
}
