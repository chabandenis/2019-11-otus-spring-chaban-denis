package ru.chaban.ex05v2.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05v2.domain.Author;

import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection",  "SqlDialectInspection"})
@Repository
public class AuthorDaoImpl implements AuthorDao {
    private final JdbcOperations jdbc;

    public AuthorDaoImpl(JdbcOperations jdbcOperations)
    {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(Author author) {

    }

    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(1) from authors", Integer.class);
    }
}
