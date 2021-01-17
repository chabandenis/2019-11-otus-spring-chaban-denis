package ru.chaban.white_magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.MyBooks;

import java.util.Optional;

public interface MyBooksRepository extends JpaRepository<MyBooks, Long> {
    MyBooks save(MyBooks myBooks);

    Optional<MyBooks> findById(long id);

    void deleteById(MyBooks myBooks);
}
