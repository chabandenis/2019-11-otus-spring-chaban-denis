package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.MyBooks;

import java.util.List;

public interface MyBooksDao {
    void insert(MyBooks myBooks);
    void update(MyBooks myBooks);
    void deleteById(long id);

    MyBooks getById(long id);
    List<MyBooks> getAll();
    int count();
}
