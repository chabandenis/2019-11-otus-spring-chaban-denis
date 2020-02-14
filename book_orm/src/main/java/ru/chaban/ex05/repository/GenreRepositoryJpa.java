package ru.chaban.ex05.repository;

import ru.chaban.ex05.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepositoryJpa {
    Genre save(Genre genre);

    Optional<Genre> findById(long id);

    List<Genre> findAll();

    List<Genre> findByName(String name);

    void updateNameById(long id, String name);

    void deleteById(long id);
}
