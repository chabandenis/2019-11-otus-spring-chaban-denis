package ru.chaban.ex05v2.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05v2.domain.MyBooks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection",  "SqlDialectInspection"})
@Repository
public class MyBooksDaoImpl implements MyBooksDao {
    private final NamedParameterJdbcOperations jdbc;

    public MyBooksDaoImpl(NamedParameterJdbcOperations jdbcOperations)
    {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(MyBooks myBooks) {
        jdbc.update("insert into my_book (`id`, `my_book_id`) values (?, ?)",
                myBooks.getId(), myBooks.getMyBookId());
    }

    @Override
    public void update(MyBooks myBooks) {
        jdbc.update("update my_book set my_book_id = ? where id = ?",
                myBooks.getMyBookId(), myBooks.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from my_book where `id` = ? ", id);
    }

    @Override
    public MyBooks getById(long id) {
        return jdbc.queryForObject("select * from genre where `id` = ? ",
                new Object[]{id}, new Mapper());
    }

    @Override
    public List<MyBooks> getAll() {
        return jdbc.query("select * from my_books", new Mapper());
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(1) from my_books", Integer.class);
    }

    private static class Mapper implements RowMapper<MyBooks> {
        @Override
        public MyBooks mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            long my_book_id = resultSet.getLong("my_book_id");
            return new MyBooks(id, my_book_id);
        }
    }
}
