package hw6.dao.author;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.hw5.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new Author(id, firstName, lastName);
    }
}