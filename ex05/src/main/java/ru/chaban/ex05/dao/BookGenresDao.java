package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.BookGenres;

import java.util.List;
import java.util.UUID;

public interface BookGenresDao {
    long insert(BookGenres bookGenres);

    void update(BookGenres bookGenres);

    void deleteById(long id);

    BookGenres getById(long id);

    List<BookGenres> getAll();

    public List<BookGenres> allByBookId(UUID genreId);

    int count();
}
