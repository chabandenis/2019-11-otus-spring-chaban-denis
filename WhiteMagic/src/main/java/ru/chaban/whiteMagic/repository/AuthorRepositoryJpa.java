package ru.chaban.whiteMagic.repository;

import ru.chaban.whiteMagic.domain.Author;

import java.util.Optional;

public interface AuthorRepositoryJpa {
    Author save(Author author);

    Optional<Author> findById(long id);

    void deleteById(Author author);
}

