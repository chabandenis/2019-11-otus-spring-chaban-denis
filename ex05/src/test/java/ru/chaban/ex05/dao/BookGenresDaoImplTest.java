package ru.chaban.ex05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.BookGenres;

import java.util.List;
import java.util.UUID;

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
        UUID uuidBook = UUID.fromString("00000000-0000-0000-0000-00000000000" + 1);
        UUID uuidBookNew = UUID.fromString("00000000-0000-0000-0000-00000000000" + 2);

        long idBookGenre = bookGenresDao.insert(new BookGenres(uuidBook, uuidBookNew));

        assertEquals(uuidBook, bookGenresDao.getById(idBookGenre).getBookId());
        assertEquals(uuidBookNew, bookGenresDao.getById(idBookGenre).getGenreId());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        UUID uuidBook = UUID.fromString("00000000-0000-0000-0000-0000000000" + 11);
        UUID uuidGenre= UUID.fromString("00000000-0000-0000-0000-0000000000" + 22);

        UUID uuidBookNew = UUID.fromString("00000000-0000-0000-0000-0000000000" + 33);
        UUID uuidGenreNew = UUID.fromString("00000000-0000-0000-0000-0000000000" + 44);

        long bookGenre = bookGenresDao.insert(new BookGenres(uuidBook, uuidGenre));
        assertEquals(uuidBook, bookGenresDao.getById(bookGenre).getBookId());
        assertEquals(uuidGenre, bookGenresDao.getById(bookGenre).getGenreId());

        BookGenres bookGenres = new BookGenres( bookGenre, uuidBookNew, uuidGenreNew);

        assertEquals(uuidBookNew, bookGenres.getBookId());
        assertEquals(uuidGenreNew, bookGenres.getGenreId());

        bookGenresDao.update(bookGenres);

        assertEquals(uuidBookNew, bookGenresDao.getById(bookGenre).getBookId());
        assertEquals(uuidGenreNew, bookGenresDao.getById(bookGenre).getGenreId());

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
        assertEquals(bookGenres.getBookId(), UUID.fromString("00000000-0000-0000-0000-000000000003"));
        assertEquals(bookGenres.getGenreId(), UUID.fromString("00000000-0000-0000-0000-000000000003"));
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<BookGenres> bookGenres = bookGenresDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(bookGenres.get(i).getId() + "; " + bookGenres.get(i).getBookId());
            assertEquals("00000000-0000-0000-0000-00000000000" + String.valueOf(i + 1),
                    String.valueOf(bookGenres.get(i).getBookId()));
            assertEquals("00000000-0000-0000-0000-00000000000" + String.valueOf(i + 1),
                    String.valueOf(bookGenres.get(i).getGenreId()));
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(bookGenresDao.count(), 5);
    }

}