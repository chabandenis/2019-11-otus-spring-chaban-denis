package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.Author;
import ru.chaban.ex05v2.domain.BookAuthors;

import java.util.List;

public interface BookAuthorsDao {
    void insert(BookAuthors bookAuthors);
    Author getById(Long id);
    List<BookAuthors> getAll();
    int count();
}
