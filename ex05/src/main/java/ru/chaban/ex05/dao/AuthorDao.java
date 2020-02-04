package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorDao {
    void insert(Author author);

    void update(Author author);

    void deleteById(long id);

    Author getById(UUID id);

    List<Author> getAll();

    int count();
}
