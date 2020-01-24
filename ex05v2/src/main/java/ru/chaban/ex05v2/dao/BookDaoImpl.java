package ru.chaban.ex05v2.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05v2.domain.Author;
import ru.chaban.ex05v2.domain.Book;

import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
@Repository
public class BookDaoImpl implements BookDao {

    private final JdbcOperations jdbc;

    public BookDaoImpl(JdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(1) from books", Integer.class);
    }
}
