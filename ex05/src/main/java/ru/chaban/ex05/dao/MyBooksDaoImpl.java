package ru.chaban.ex05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.MyBooks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
@Repository
public class MyBooksDaoImpl implements MyBooksDao {
    private final NamedParameterJdbcOperations jdbc;

    public MyBooksDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public long insert(MyBooks myBooks) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("my_book_id", myBooks.getMyBookId());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update("insert into my_books (my_book_id) values (:my_book_id)", params, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public void update(MyBooks myBooks) {
        final Map<String, Object> params = new HashMap<>(2);
        params.put("id", myBooks.getId());
        params.put("my_book_id", myBooks.getMyBookId());

        jdbc.update("update my_books set my_book_id = :my_book_id where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);

        jdbc.update("delete from my_books where id = :id ", params);
    }

    @Override
    public MyBooks getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.queryForObject("select * from my_books where id = :id ", params, new Mapper());
    }

    @Override
    public List<MyBooks> getAll() {
        return jdbc.query("select * from my_books", new Mapper());
    }

    @Override
    public int count() {
        final Map<String, Object> params = new HashMap<>(1);
        return jdbc.queryForObject("select count(1) from my_books", params, Integer.class);
    }

    private static class Mapper implements RowMapper<MyBooks> {
        @Override
        public MyBooks mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            UUID my_book_id = (UUID) resultSet.getObject("my_book_id");
            return new MyBooks(id, my_book_id);
        }
    }
}
