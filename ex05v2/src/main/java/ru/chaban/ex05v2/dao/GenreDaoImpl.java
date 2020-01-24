package ru.chaban.ex05v2.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05v2.domain.Genre;

import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection",  "SqlDialectInspection"})
@Repository
public class GenreDaoImpl implements GenreDao {

    private final JdbcOperations jdbc;

    public GenreDaoImpl(JdbcOperations jdbcOperations)
    {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(Genre genre) {

    }

    @Override
    public Genre getById(Long id) {
        return null;
    }

    @Override
    public List<Genre> getAll() {
        return null;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(1) from genre", Integer.class);
    }
}
