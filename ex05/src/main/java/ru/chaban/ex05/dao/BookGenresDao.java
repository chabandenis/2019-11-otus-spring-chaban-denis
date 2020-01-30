package ru.chaban.ex05.dao;

import ru.chaban.ex05.domain.BookGenres;

import java.util.List;

public interface BookGenresDao {
    void insert(BookGenres bookGenres);
    void update(BookGenres bookGenres);
    void deleteById(long id);

    BookGenres getById(long id);

    List<BookGenres> getAll();
    public List<BookGenres> allByBookId(long genreId);

    int count();
}
