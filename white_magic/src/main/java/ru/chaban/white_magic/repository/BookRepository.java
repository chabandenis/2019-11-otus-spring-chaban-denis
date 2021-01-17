package ru.chaban.white_magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book save(Book book);

    Optional<Book> findById(long id);

    void deleteById(Book book);

    List<Book> findAll();

    List<Book> findByName(String name);
}
