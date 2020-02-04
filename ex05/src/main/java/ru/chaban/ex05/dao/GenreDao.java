package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.Genre;

import java.util.List;
import java.util.UUID;

public interface GenreDao {
    void insert(Genre genre);

    void update(Genre genre);

    void deleteById(long id);

    Genre getById(UUID id);

    List<Genre> getAll();

    int count();
}
