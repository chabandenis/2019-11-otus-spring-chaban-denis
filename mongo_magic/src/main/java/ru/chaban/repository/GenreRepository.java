package ru.chaban.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.chaban.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, Long> {
/*    Optional<Genre> findById(long id);

    List<Genre> findByName(String name);*/
}
