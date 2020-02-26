package ru.chaban.ex05.repository;

import ru.chaban.ex05.domain.MyBooks;

import java.util.Optional;

public interface MyBooksRepositoryJpa {
    MyBooks save(MyBooks myBooks);

    Optional<MyBooks> findById(long id);

    void deleteById(long id);
}
