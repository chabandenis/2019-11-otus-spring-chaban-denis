package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.Book;

import java.util.List;
import java.util.UUID;

public interface BookDao {

    Book getById(UUID id);

    List<Book> getAll();

    void insert(Book book);

    void update(Book book);

    void deleteById(long id);

    int count();
}
