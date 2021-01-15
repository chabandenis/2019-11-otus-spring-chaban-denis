package ru.chaban.white_magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.MyBooks;

public interface MyBooksRepository extends JpaRepository<MyBooks, Long> {
}
