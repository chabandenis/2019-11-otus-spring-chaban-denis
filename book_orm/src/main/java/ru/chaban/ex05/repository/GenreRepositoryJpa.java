package ru.chaban.ex05.repository;

import ru.chaban.ex05.domain.Genre;

import java.util.Optional;

public interface GenreRepositoryJpa {
    Genre save(Genre genre);

    Optional<Genre> findById(long id);

    void deleteById(Genre genre);
}
