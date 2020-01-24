package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.MyBooks;

import java.util.List;

public interface MyBooksDao {
    void insert(MyBooks myBooks);
    MyBooks getById(Long id);
    List<MyBooks> getAll();
    int count();
}
