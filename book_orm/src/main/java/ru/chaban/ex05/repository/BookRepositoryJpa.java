package ru.chaban.ex05.repository;

import ru.chaban.ex05.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryJpa {
    Book save(Book book);

    Optional<Book> findById(long id);

    List<Book> findAll();

    List<Book> findByName(String name);

    void updateNameById(long id, String name);

    void deleteById(long id);
}
