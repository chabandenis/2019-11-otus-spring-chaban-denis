package ru.chaban.ex05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
@Repository
public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    public BookDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(Book book) {
        final Map<String, Object> params = new HashMap<>(2);
        params.put("id", book.getId());
        params.put("name", book.getName());

        jdbc.update("insert into book (id, name) values(:id, :name)", params);
    }

    @Override
    public void update(Book book) {
        final Map<String, Object> params = new HashMap<>(2);
        params.put("id", book.getId());
        params.put("name", book.getName());

        jdbc.update("update book set name=:name where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        jdbc.update("delete from book where id = :id", params);
    }

    @Override
    public Book getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);

        return jdbc.queryForObject("select * from books where id = :id ", params, new Mapper());
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select * from books", new Mapper());
    }

    @Override
    public int count() {
        final Map<String, Object> params = new HashMap<>(0);
        return jdbc.queryForObject("select count(1) from books", params, Integer.class);
    }

    private static class Mapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Book(id, name, new ArrayList<>(), new ArrayList<>());
        }
    }
}
