package ru.chaban.whiteMagic.repository;

import ru.chaban.whiteMagic.domain.Opinion;

import java.util.Optional;

public interface OpinionRepositoryJpa {
    Opinion save(Opinion opinion);

    Optional<Opinion> findById(long id);

    void deleteById(Opinion opinion);
}
