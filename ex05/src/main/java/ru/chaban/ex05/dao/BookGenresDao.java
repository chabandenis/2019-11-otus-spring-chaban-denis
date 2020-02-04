package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.BookGenres;

import java.util.List;
import java.util.UUID;

public interface BookGenresDao {
    BookGenres getById(long id);

    List<BookGenres> getAll();

    List<BookGenres> allByBookId(UUID genreId);

    long insert(BookGenres bookGenres);

    void update(BookGenres bookGenres);

    void deleteById(long id);

    int count();
}
