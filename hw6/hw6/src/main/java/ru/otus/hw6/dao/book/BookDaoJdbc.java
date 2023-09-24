package ru.otus.hw6.dao.book;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import ru.otus.hw6.domain.Book;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public List<Book> getAll() {
        var sql = "select b.id, b.title, a.id as author_id, a.first_name, a.last_name, g.id as genre_id, g.name" +
                " from books b" +
                " left join authors a on a.id=b.author_id" +
                " left join genres g on g.id=b.genre_id";
        return jdbc.query(sql, new BookMapper());
    }

    @Override
    public Book getById(long id) {
        var sql = "select b.id, b.title, a.id as author_id, a.first_name, a.last_name, g.id as genre_id, g.name" +
                " from books b" +
                " left join authors a on a.id=b.author_id" +
                " left join genres g on g.id=b.genre_id" +
                " where id=:id";
        return jdbc.queryForObject(sql, Map.of("id", id), new BookMapper());
    }

    @Override
    public long insert(Book book) {
        var keyHolder = new GeneratedKeyHolder();
        jdbc.update("insert into books (title, author_id, genre_id)" +
                        " values (:title, :author_id, :genre_id)", createBookParams(book)
                , keyHolder, new String[]{"id"});
        return keyHolder.getKey().longValue();
    }

    @Override
    public void update(Book book) {
        var updated = jdbc.update("update books set title=:title, author_id=:author_id, genre_id=:genre_id" +
                " where id=:id", createBookParamsWithId(book));
        if (updated == 0) {

        }
    }

    @Override
    public void delete(long id) {
        jdbc.update("delete from books where id=:id", Map.of("id", id));
    }

    private MapSqlParameterSource createBookParams(Book book) {
        var params = new MapSqlParameterSource();
        params.addValue("title", book.title());
        params.addValue("author_id", book.author().id());
        params.addValue("genre_id", book.genre().id());
        return params;
    }

    private MapSqlParameterSource createBookParamsWithId(Book book) {
        var params = new MapSqlParameterSource();
        params.addValue("id", book.id());
        params.addValue("title", book.title());
        params.addValue("author_id", book.author().id());
        params.addValue("genre_id", book.genre().id());
        return params;
    }
}
