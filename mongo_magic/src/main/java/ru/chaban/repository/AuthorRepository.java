package ru.chaban.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.chaban.domain.Author;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {
    List<Author> findByName(String name);
}
