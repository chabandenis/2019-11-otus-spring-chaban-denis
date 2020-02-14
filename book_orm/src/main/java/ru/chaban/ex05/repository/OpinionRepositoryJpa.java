package ru.chaban.ex05.repository;

import ru.chaban.ex05.domain.Opinion;

import java.util.List;
import java.util.Optional;

public interface OpinionRepositoryJpa {
    Opinion save(Opinion opinion);

    Optional<Opinion> findById(long id);

    List<Opinion> findAll();

    List<Opinion> findByName(String name);

    void updateNameById(long id, String name);

    void deleteById(long id);
}
