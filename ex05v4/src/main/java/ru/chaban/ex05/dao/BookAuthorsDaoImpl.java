package ru.chaban.ex05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
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
    public void insert(BookAuthors bookAuthors) {
        final Map<String, Object> params = new HashMap<>(3);
        params.put("id", bookAuthors.getId());
        params.put("book_id", bookAuthors.getBookId());
        params.put("author_id", bookAuthors.getAuthorId());

        jdbc.update("insert into bool_authors (id, book_id, author_id) value(:id,:book_id,:author_id)", params);
    }

    @Override
    public void update(BookAuthors bookAuthors) {
        final Map<String, Object> params = new HashMap<>(3);
        params.put("id", bookAuthors.getId());
        params.put("book_id", bookAuthors.getBookId());
        params.put("author_id", bookAuthors.getAuthorId());

        jdbc.update("update bool_authors set book_id=:book_id and author_id=:author_id where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        jdbc.update("delete from bool_authors where id = :id", params);
    }

    @Override
    public BookAuthors getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.queryForObject("select * from book_authors where id = :id ",
                params, new Mapper());
    }

    @Override
    public List<BookAuthors> getAll() {
        return jdbc.query("select * from book_authors", new Mapper());
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
