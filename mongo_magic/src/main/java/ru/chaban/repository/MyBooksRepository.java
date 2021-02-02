package ru.chaban.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.chaban.domain.MyBooks;

import java.util.List;
import java.util.Optional;

public interface MyBooksRepository extends MongoRepository<MyBooks, Long> {
    /*
    Optional<MyBooks> findById(long id);

    List<MyBooks> findByBook_Name(String name);*/
}
