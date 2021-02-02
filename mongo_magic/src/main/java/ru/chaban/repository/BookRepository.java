package ru.chaban.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.chaban.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, Long> {
/*    Optional<Book> findById(long id);

    List<Book> findByName(String name);*/
}
