package ru.chaban.white_magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre save(Genre genre);

    Optional<Genre> findById(long id);

    void deleteById(Genre genre);

    List<Genre> findAll();

    List<Genre> findByName(String name);
}
