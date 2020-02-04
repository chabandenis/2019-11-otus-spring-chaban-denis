package ru.chaban.ex05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
@Repository
public class AuthorDaoImpl implements AuthorDao {
    private final NamedParameterJdbcOperations jdbc;

    public AuthorDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(Author author) {
        final Map<String, Object> params = new HashMap<>(2);
        params.put("id", author.getId());
        params.put("name", author.getName());

        jdbc.update("insert into authors(`id`, `name`) values (:id, :name) ", params);
    }

    @Override
    public void update(Author author) {
        final Map<String, Object> params = new HashMap<>(2);
        params.put("id", author.getId());
        params.put("name", author.getName());

        jdbc.update("update authors set name = :name where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        jdbc.update(" delete from authors where id = :id", params);
    }

    @Override
    public Author getById(UUID id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.queryForObject("select * from authors where id = :id ", params, new Mapper());
    }

    @Override
    public List<Author> getAll() {
        return jdbc.query("select * from authors", new Mapper());
    }

    @Override
    public int count() {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", 0);
        return jdbc.queryForObject("select count(1) from authors", params, Integer.class);
    }

    private static class Mapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            UUID id = (UUID) resultSet.getObject("id");
            String name = resultSet.getString("name");
            return new Author(id, name);
        }
    }
}
