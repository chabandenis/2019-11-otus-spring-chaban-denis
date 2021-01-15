package ru.chaban.whiteMagic.repository;

import ru.chaban.whiteMagic.domain.Book;

import java.util.Optional;

public interface BookRepositoryJpa {
    Book save(Book book);

    Optional<Book> findById(long id);

    void deleteById(Book book);
}
