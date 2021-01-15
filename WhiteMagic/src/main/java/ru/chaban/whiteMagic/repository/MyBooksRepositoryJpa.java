package ru.chaban.whiteMagic.repository;

import ru.chaban.whiteMagic.domain.MyBooks;

import java.util.Optional;

public interface MyBooksRepositoryJpa {
    MyBooks save(MyBooks myBooks);

    Optional<MyBooks> findById(long id);

    void deleteById(MyBooks myBooks);
}
