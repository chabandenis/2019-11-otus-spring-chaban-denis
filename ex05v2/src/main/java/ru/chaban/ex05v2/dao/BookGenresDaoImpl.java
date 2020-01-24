package ru.chaban.ex05v2.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05v2.domain.Author;
import ru.chaban.ex05v2.domain.BookGenres;

import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection",  "SqlDialectInspection"})
@Repository
public class BookGenresDaoImpl implements BookGenresDao{
    private final JdbcOperations jdbc;

    public BookGenresDaoImpl(JdbcOperations jdbcOperations)
    {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(BookGenres bookGenres) {

    }

    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public List<BookGenres> getAll() {
        return null;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("slect count(1) from book_genres", Integer.class);
    }
}
