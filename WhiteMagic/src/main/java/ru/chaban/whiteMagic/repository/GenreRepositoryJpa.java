package ru.chaban.whiteMagic.repository;

import ru.chaban.whiteMagic.domain.Genre;

import java.util.Optional;

public interface GenreRepositoryJpa {
    Genre save(Genre genre);

    Optional<Genre> findById(long id);

    void deleteById(Genre genre);
}
