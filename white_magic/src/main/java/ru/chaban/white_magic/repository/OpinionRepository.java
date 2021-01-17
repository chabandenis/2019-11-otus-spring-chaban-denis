package ru.chaban.white_magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.Opinion;

import java.util.List;
import java.util.Optional;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
    Opinion save(Opinion opinion);

    Optional<Opinion> findById(long id);

    void deleteById(Opinion opinion);

    List<Opinion> findAll();

    List<Opinion> findByComment(String name);
}
