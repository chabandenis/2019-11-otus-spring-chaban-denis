package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.Author;
import ru.chaban.ex05v2.domain.Book;
import ru.chaban.ex05v2.domain.BookAuthors;

import java.util.List;

public interface BookDao {
    void insert(Book book);
    Author getById(Long id);
    List<Book> getAll();
    int count();
}
