package ru.chaban.ex05v2.dao;

import ru.chaban.ex05v2.domain.Author;
import ru.chaban.ex05v2.domain.Book;
import ru.chaban.ex05v2.domain.BookGenres;

import java.util.List;

public interface BookGenresDao {
    void insert(BookGenres bookGenres);
    Author getById(Long id);
    List<BookGenres> getAll();
    int count();
}
