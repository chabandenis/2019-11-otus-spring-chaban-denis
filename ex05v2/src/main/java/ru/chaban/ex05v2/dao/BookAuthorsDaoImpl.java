package ru.chaban.ex05v2.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05v2.domain.Author;
import ru.chaban.ex05v2.domain.BookAuthors;

import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection",  "SqlDialectInspection"})
@Repository
public class BookAuthorsDaoImpl implements BookAuthorsDao {
    private final JdbcOperations jdbc;

    public BookAuthorsDaoImpl(JdbcOperations jdbcOperations)
    {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(BookAuthors bookAuthors) {

    }

    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public List<BookAuthors> getAll() {
        return null;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(1) from book_authors", Integer.class);
    }
}
