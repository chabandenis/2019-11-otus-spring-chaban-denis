package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.MyBooks;

import java.util.List;

public interface MyBooksDao {

    MyBooks getById(long id);

    List<MyBooks> getAll();

    long insert(MyBooks myBooks);

    void update(MyBooks myBooks);

    void deleteById(long id);

    int count();
}
