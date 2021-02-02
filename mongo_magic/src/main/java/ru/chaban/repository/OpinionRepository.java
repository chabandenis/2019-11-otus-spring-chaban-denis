package ru.chaban.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.chaban.domain.Opinion;

import java.util.List;
import java.util.Optional;

public interface OpinionRepository extends MongoRepository<Opinion, String> {

    Optional<Opinion> findById(long id);

    void deleteById(Opinion opinion);

    List<Opinion> findByComment(String name);
}
