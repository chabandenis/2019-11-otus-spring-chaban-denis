package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorDao {
    Author getById(UUID id);

    List<Author> getAll();

    void insert(Author author);

    void update(Author author);

    void deleteById(long id);

    int count();
}
