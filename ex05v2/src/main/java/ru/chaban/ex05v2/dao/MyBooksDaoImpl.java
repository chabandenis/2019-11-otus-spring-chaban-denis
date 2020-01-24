package ru.chaban.ex05v2.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05v2.domain.MyBooks;

import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection",  "SqlDialectInspection"})
@Repository
public class MyBooksDaoImpl implements MyBooksDao {
    private final JdbcOperations jdbc;

    public MyBooksDaoImpl(JdbcOperations jdbcOperations)
    {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(MyBooks myBooks) {

    }

    @Override
    public MyBooks getById(Long id) {
        return null;
    }

    @Override
    public List<MyBooks> getAll() {
        return null;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(1) from my_books", Integer.class);
    }
}
