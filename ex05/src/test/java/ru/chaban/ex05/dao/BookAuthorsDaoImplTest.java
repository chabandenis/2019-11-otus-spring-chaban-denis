package ru.chaban.ex05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.Author;
import ru.chaban.ex05.domain.BookAuthors;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@DisplayName("Проверим связь книги и автора")
@JdbcTest
@Import(BookAuthorsDaoImpl.class)
class BookAuthorsDaoImplTest {

    @Autowired
    private BookAuthorsDao bookAuthorsDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        UUID uuidBook = UUID.fromString("00000000-0000-0000-0000-0000000000" + 11);
        UUID uuidAuthor = UUID.fromString("00000000-0000-0000-0000-0000000000" + 22);
        long idBookAutors = bookAuthorsDao.insert(new BookAuthors(uuidBook, uuidAuthor));
        assertEquals(uuidBook, bookAuthorsDao.getById(idBookAutors).getBookId());
        assertEquals(uuidAuthor, bookAuthorsDao.getById(idBookAutors).getAuthorId());
    }

    @Test
    void constructor() {
        UUID uuidBook = UUID.fromString("00000000-0000-0000-0000-0000000000" + 11);
        UUID uuidAuthor = UUID.fromString("00000000-0000-0000-0000-0000000000" + 22);

        BookAuthors bookAuthors = new BookAuthors(uuidBook, uuidAuthor);

        assertEquals(uuidBook, bookAuthors.getBookId());
        assertEquals(uuidAuthor, bookAuthors.getAuthorId());
    }


    @DisplayName("изменение")
    @Test
    void update() {
        UUID uuidBook = UUID.fromString("00000000-0000-0000-0000-0000000000" + 11);
        UUID uuidAuthor = UUID.fromString("00000000-0000-0000-0000-0000000000" + 22);

        UUID uuidBookNew = UUID.fromString("00000000-0000-0000-0000-0000000000" + 33);
        UUID uuidAuthorNew = UUID.fromString("00000000-0000-0000-0000-0000000000" + 44);


        long idBookAutors = bookAuthorsDao.insert(new BookAuthors(uuidBook, uuidAuthor));
        assertEquals(uuidBook, bookAuthorsDao.getById(idBookAutors).getBookId());
        assertEquals(uuidAuthor, bookAuthorsDao.getById(idBookAutors).getAuthorId());

        BookAuthors bookAuthors = new BookAuthors(uuidBookNew, uuidAuthorNew);
        bookAuthors.setId(idBookAutors);

        assertEquals(uuidBookNew, bookAuthors.getBookId());
        assertEquals(uuidAuthorNew, bookAuthors.getAuthorId());

        bookAuthorsDao.update(bookAuthors);

        assertEquals(uuidBookNew, bookAuthorsDao.getById(idBookAutors).getBookId());
        assertEquals(uuidAuthorNew, bookAuthorsDao.getById(idBookAutors).getAuthorId());

    }

    @DisplayName("удаление")
    @Test
    void deleteById() {
        assertEquals(bookAuthorsDao.count(), 5);
        bookAuthorsDao.deleteById(5);
        assertEquals(bookAuthorsDao.count(), 4);
    }

    @DisplayName("по ID")
    @Test
    void getById() {
        BookAuthors bookAuthors = bookAuthorsDao.getById(3);
        assertEquals(bookAuthors.getBookId(), UUID.fromString("00000000-0000-0000-0000-000000000003"));
        assertEquals(bookAuthors.getAuthorId(), UUID.fromString("00000000-0000-0000-0000-000000000003"));
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<BookAuthors> bookAuthors = bookAuthorsDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(bookAuthors.get(i).getId() + "; " + bookAuthors.get(i).getBookId());

            assertEquals("00000000-0000-0000-0000-00000000000" + String.valueOf(i + 1),
                    String.valueOf(bookAuthors.get(i).getBookId()));
            assertEquals("00000000-0000-0000-0000-00000000000" + String.valueOf(i + 1),
                    String.valueOf(bookAuthors.get(i).getAuthorId()));
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(bookAuthorsDao.count(), 5);
    }

}