package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.BookAuthors;

import java.util.List;

public interface BookAuthorsDao {

    BookAuthors getById(long id);

    List<BookAuthors> getAll();

    List<BookAuthors> allByBookId(long bookId);

    long insert(BookAuthors bookAuthors);

    void update(BookAuthors bookAuthors);

    void deleteById(long id);

    int count();
}
