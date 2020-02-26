package ru.chaban.ex05.repository;

import ru.chaban.ex05.domain.Book;

import java.util.Optional;

public interface BookRepositoryJpa {
    Book save(Book book);

    Optional<Book> findById(long id);

    void deleteById(Book book);
}
