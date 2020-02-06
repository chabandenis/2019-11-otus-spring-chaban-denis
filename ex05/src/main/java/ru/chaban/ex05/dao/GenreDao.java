package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.Genre;

import java.util.List;

public interface GenreDao {
    Genre getById(long id);

    List<Genre> getAll();

    void insert(Genre genre);

    void update(Genre genre);

    void deleteById(long id);

    int count();
}
