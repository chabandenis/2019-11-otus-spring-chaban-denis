package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.Book;

import java.util.List;

public interface BookDao {
    void insert(Book book);
    void update(Book book);
    void deleteById(long id);

    Book getById(long id);
    List<Book> getAll();
    int count();
}
