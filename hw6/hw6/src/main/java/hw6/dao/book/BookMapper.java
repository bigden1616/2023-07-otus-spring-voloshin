package hw6.dao.book;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.hw5.domain.Author;
import ru.otus.hw5.domain.Book;
import ru.otus.hw5.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        var id = rs.getLong("id");
        var title = rs.getString("title");

        var genreId = rs.getLong("genre_id");
        var genreName = rs.getString("name");
        var genre = new Genre(genreId, genreName);

        var authorId = rs.getLong("author_id");
        var firstName = rs.getString("first_name");
        var lastName = rs.getString("last_name");
        var author = new Author(authorId, firstName, lastName);

        return new Book(id, title, author, genre);
    }

}
