package ru.chaban.ex05.repository;

import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.Author;

import java.util.Optional;

public interface AuthorRepositoryJpa {
    Author save(Author author);

    Optional<Author> findById(long id);

    void deleteById(Author author);
}

