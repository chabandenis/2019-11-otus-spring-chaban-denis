package ru.chaban.white_magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
