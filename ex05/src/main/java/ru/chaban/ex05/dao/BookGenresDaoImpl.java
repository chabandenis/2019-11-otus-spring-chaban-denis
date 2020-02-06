package ru.chaban.ex05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.BookGenres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
@Repository
public class BookGenresDaoImpl implements BookGenresDao {
    private final NamedParameterJdbcOperations jdbc;

    public BookGenresDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public long insert(BookGenres bookGenres) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("book_id", bookGenres.getBookId());
        params.addValue("genre_id", bookGenres.getGenreId());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update("insert into book_genres (book_id, genre_id) values (:book_id, :genre_id)", params, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public void update(BookGenres bookGenres) {
        final Map<String, Object> params = new HashMap<>(3);
        params.put("id", bookGenres.getId());
        params.put("book_id", bookGenres.getBookId());
        params.put("genre_id", bookGenres.getGenreId());

        jdbc.update("update book_genres set book_id =:book_id, genre_id =:genre_id where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        jdbc.update("delete from book_genres where id= :id", params);
    }

    @Override
    public BookGenres getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.queryForObject("select id, book_id, genre_id from book_genres where id = :id ", params, new Mapper());
    }

    @Override
    public List<BookGenres> getAll() {
        return jdbc.query("select id, book_id, genre_id from book_genres", new Mapper());
    }

    @Override
    public List<BookGenres> allByBookId(long genreId) {
        return jdbc.query("select id, book_id, genre_id from book_genres where genre_id = " + genreId, new Mapper());
    }

    @Override
    public int count() {
        final Map<String, Object> params = new HashMap<>(1);
        return jdbc.queryForObject("select count(1) from book_genres", params, Integer.class);
    }

    private static class Mapper implements RowMapper<BookGenres> {
        @Override
        public BookGenres mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            long bookId = resultSet.getLong("book_id");
            long genreId = resultSet.getLong("genre_id");
            return new BookGenres(id, bookId, genreId);
        }
    }
}
