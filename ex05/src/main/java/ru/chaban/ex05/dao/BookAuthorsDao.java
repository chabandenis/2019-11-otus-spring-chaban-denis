package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.BookAuthors;
import java.util.List;
import java.util.UUID;

public interface BookAuthorsDao {

    BookAuthors getById(long id);

    List<BookAuthors> getAll();

    List<BookAuthors> allByBookId(UUID bookId);

    long insert(BookAuthors bookAuthors);

    void update(BookAuthors bookAuthors);

    void deleteById(long id);

    int count();
}
