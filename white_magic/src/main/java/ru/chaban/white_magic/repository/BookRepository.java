package ru.chaban.white_magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
