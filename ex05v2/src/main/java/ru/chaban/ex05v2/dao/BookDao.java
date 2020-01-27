package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.Book;

import java.util.List;

public interface BookDao {
    void insert(Book book);
    void update(Book book);
    void deleteById(long id);

    Book getById(long id);
    List<Book> getAll();
    int count();
}
