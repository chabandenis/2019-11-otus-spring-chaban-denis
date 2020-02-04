package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.BookAuthors;
import java.util.List;
import java.util.UUID;

public interface BookAuthorsDao {

    long insert(BookAuthors bookAuthors);

    void update(BookAuthors bookAuthors);

    void deleteById(long id);

    BookAuthors getById(long id);

    List<BookAuthors> getAll();

    List<BookAuthors> allByBookId(UUID bookId);

    int count();
}
