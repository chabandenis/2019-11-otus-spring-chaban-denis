package ru.chaban.ex05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.BookAuthors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
@Repository
public class BookAuthorsDaoImpl implements BookAuthorsDao {
    private final NamedParameterJdbcOperations jdbc;

    public BookAuthorsDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public long insert(BookAuthors bookAuthors) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("book_id", bookAuthors.getBookId());
        params.addValue("author_id", bookAuthors.getAuthorId());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update("insert into book_authors (book_id, author_id) values (:book_id,:author_id)", params, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public void update(BookAuthors bookAuthors) {
        final Map<String, Object> params = new HashMap<>(3);
        params.put("id", bookAuthors.getId());
        params.put("book_id", bookAuthors.getBookId());
        params.put("author_id", bookAuthors.getAuthorId());

        jdbc.update("update book_authors set book_id=:book_id, author_id= :author_id where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        jdbc.update("delete from book_authors where id = :id", params);
    }

    @Override
    public BookAuthors getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);

        BookAuthors bookAuthors = jdbc.queryForObject("select id, book_id, author_id from book_authors where id = :id ",
                params, new Mapper());
        return bookAuthors;
    }

    @Override
    public List<BookAuthors> getAll() {
        return jdbc.query("select id, book_id, author_id from book_authors", new Mapper());
    }

    @Override
    public List<BookAuthors> allByBookId(long bookId) {
        return jdbc.query("select id, book_id, author_id from book_authors where book_id = " + bookId, new Mapper());
    }

    @Override
    public int count() {
        final Map<String, Object> params = new HashMap<>(0);
        return jdbc.queryForObject("select count(1) from book_authors", params, Integer.class);
    }

    private static class Mapper implements RowMapper<BookAuthors> {
        @Override
        public BookAuthors mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            long bookId = resultSet.getLong("book_id");
            long authorId = resultSet.getLong("author_id");
            return new BookAuthors(id, bookId, authorId);
        }
    }
}
