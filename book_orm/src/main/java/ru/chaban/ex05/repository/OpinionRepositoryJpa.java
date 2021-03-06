package ru.chaban.ex05.repository;

import ru.chaban.ex05.domain.Opinion;

import java.util.Optional;

public interface OpinionRepositoryJpa {
    Opinion save(Opinion opinion);

    Optional<Opinion> findById(long id);

    void deleteById(Opinion opinion);
}
