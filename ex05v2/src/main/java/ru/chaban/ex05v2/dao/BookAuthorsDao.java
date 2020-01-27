package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.BookAuthors;

import java.util.List;

public interface BookAuthorsDao {
    void insert(BookAuthors bookAuthors);
    void update(BookAuthors bookAuthors);
    void deleteById(long id);

    BookAuthors getById(long id);
    List<BookAuthors> getAll();
    int count();
}
