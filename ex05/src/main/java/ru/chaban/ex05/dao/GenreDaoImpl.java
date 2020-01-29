package ru.chaban.ex05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
@Repository
public class GenreDaoImpl implements GenreDao {

    private final NamedParameterJdbcOperations jdbc;

    public GenreDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }


    @Override
    public void insert(Genre genre) {
        final Map<String, Object> params = new HashMap<>(2);
        params.put("id", genre.getId());
        params.put("name", genre.getName());

        jdbc.update("insert into genres (id, name) values (:id, :name) ", params);
    }

    @Override
    public void update(Genre genre) {
        final Map<String, Object> params = new HashMap<>(2);
        params.put("id", genre.getId());
        params.put("name", genre.getName());

        jdbc.update("update genres set name = :name where id = :id ", params);
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        jdbc.update("delete from genres where id = :id", params);
    }

    @Override
    public Genre getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.queryForObject("select * from genres where id = :id ",
                params, new Mapper());
    }

    @Override
    public List<Genre> getAll() {
        return jdbc.query("select * from genres", new Mapper());
    }

    @Override
    public int count() {
        final Map<String, Object> params = new HashMap<>(0);
        return jdbc.queryForObject("select count(1) from genres", params, Integer.class);
    }

    private static class Mapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Genre(id, name);
        }
    }
}