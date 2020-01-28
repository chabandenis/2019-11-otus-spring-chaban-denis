package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.Author;

import java.util.List;

public interface AuthorDao {
    void insert(Author author);
    void update(Author author);
    void deleteById(long id);

    Author getById(long id);
    List<Author> getAll();
    int count();
}