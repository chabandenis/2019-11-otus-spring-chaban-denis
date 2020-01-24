package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.Genre;

import java.util.List;

public interface GenreDao {
    void insert(Genre genre);
    Genre getById(Long id);
    List<Genre> getAll();
    int count();
}
