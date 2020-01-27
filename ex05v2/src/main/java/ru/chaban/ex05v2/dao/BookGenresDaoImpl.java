package ru.chaban.ex05v2.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05v2.domain.BookGenres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
@Repository
public class BookGenresDaoImpl implements BookGenresDao {
    private final NamedParameterJdbcOperations jdbc;

    public BookGenresDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(BookGenres bookGenres) {
        final Map<String, Object> params = new HashMap<>(3);
        params.put("id", bookGenres.getId());
        params.put("book_id", bookGenres.getBookId());
        params.put("genre_Id", bookGenres.getGenreId());

        jdbc.update("insert into book_genres (id, book_Id, genre_Id) values (:id, :book_id, :genre_Id)", params);
    }

    @Override
    public void update(BookGenres bookGenres) {
        final Map<String, Object> params = new HashMap<>(3);
        params.put("id", bookGenres.getId());
        params.put("book_id", bookGenres.getBookId());
        params.put("genre_Id", bookGenres.getGenreId());

        jdbc.update("update book_genres set book_Id =:book_Id and genre_Id =:genre_Id where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Object> params = new HashMap<>(3);
        params.put("id", id);
        jdbc.update("delete from book_genres where id= :id", params);
    }

    @Override
    public BookGenres getById(long id) {
        final Map<String, Object> params = new HashMap<>(3);
        params.put("id", id);
        return jdbc.queryForObject("select * from book_genres where id = :id ", params, new Mapper());
    }

    @Override
    public List<BookGenres> getAll() {
        return jdbc.query("select * from book_genres", new Mapper());
    }

    @Override
    public int count() {
        final Map<String, Object> params = new HashMap<>(3);
        return jdbc.queryForObject("slect count(1) from book_genres", params, Integer.class);
    }

    private static class Mapper implements RowMapper<BookGenres> {
        @Override
        public BookGenres mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            long bookId = resultSet.getLong("book_Id");
            long genreId = resultSet.getLong("genre_Id");
            return new BookGenres(id, bookId, genreId);
        }
    }
}
