package ru.chaban.ex05.repository;

import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.MyBooks;

import java.util.List;
import java.util.Optional;

public interface MyBooksRepositoryJpa {
    MyBooks save(MyBooks myBooks);

    Optional<MyBooks> findById(long id);

    List<MyBooks> findAll();

    List<MyBooks> findByName(String name);

    void updateNameById(long id, Book book);

    void deleteById(long id);
}
