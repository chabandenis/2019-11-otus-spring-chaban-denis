package ru.chaban.ex05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.BookAuthors;
import ru.chaban.ex05.domain.BookGenres;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DisplayName("Проверим связь книги и жанров")
@JdbcTest
@Import(BookGenresDaoImpl.class)
class BookGenresDaoImplTest {
    @Autowired
    private BookGenresDao bookGenresDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        bookGenresDao.insert(new BookGenres(10, 1, 2));
        assertEquals(10, bookGenresDao.getById(10).getId());
        assertEquals(1, bookGenresDao.getById(10).getBookId());
        assertEquals(2, bookGenresDao.getById(10).getGenreId());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        bookGenresDao.insert(new BookGenres(10, 11, 22));
        assertEquals(11, bookGenresDao.getById(10).getBookId());
        assertEquals(22, bookGenresDao.getById(10).getGenreId());

        BookGenres bookGenres = new BookGenres(10, 33, 44);

        assertEquals(33, bookGenres.getBookId());
        assertEquals(44, bookGenres.getGenreId());

        bookGenresDao.update(bookGenres);

        assertEquals(33, bookGenresDao.getById(10).getBookId());
        assertEquals(44, bookGenresDao.getById(10).getGenreId());

    }

    @DisplayName("удаление")
    @Test
    void deleteById() {
        assertEquals(bookGenresDao.count(), 5);
        bookGenresDao.deleteById(5);
        assertEquals(bookGenresDao.count(), 4);
    }

    @DisplayName("по ID")
    @Test
    void getById() {
        BookGenres bookGenres = bookGenresDao.getById(3);
        assertEquals(bookGenres.getId(), 3);
        assertEquals(bookGenres.getBookId(), 3);
        assertEquals(bookGenres.getGenreId(), 3);
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<BookGenres> bookGenres = bookGenresDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(bookGenres.get(i).getId() + "; " + bookGenres.get(i).getBookId());
            assertEquals((i + 1), bookGenres.get(i).getId());
            assertEquals(String.valueOf(i + 1) ,
                    String.valueOf(bookGenres.get(i).getBookId()));
            assertEquals(String.valueOf(i + 1) ,
                    String.valueOf(bookGenres.get(i).getGenreId()));
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(bookGenresDao.count(), 5);
    }

}