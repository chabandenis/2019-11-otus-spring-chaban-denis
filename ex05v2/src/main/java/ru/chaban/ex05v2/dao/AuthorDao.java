package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.Author;

import java.util.List;

public interface AuthorDao {
    void insert(Author author);
    Author getById(Long id);
    List<Author> getAll();
    int count();
}
