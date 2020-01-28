package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.Genre;

import java.util.List;

public interface GenreDao {
    void insert(Genre genre);
    void update(Genre genre);
    void deleteById(long id);

    Genre getById(long id);
    List<Genre> getAll();
    int count();
}