package ru.chaban.white_magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.Author;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author save(Author author);

    Optional<Author> findById(long id);

    void deleteById(Author author);
}
