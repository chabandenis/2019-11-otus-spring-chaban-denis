package ru.chaban.ex05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.Author;
import ru.chaban.ex05.domain.BookAuthors;

import java.util.List;

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
        bookAuthorsDao.insert(new BookAuthors(10, 1, 2));
        assertEquals(10, bookAuthorsDao.getById(10).getId());
        assertEquals(1, bookAuthorsDao.getById(10).getBookId());
        assertEquals(2, bookAuthorsDao.getById(10).getAuthorId());
    }

    @Test
    void constructor() {
        BookAuthors bookAuthors = new BookAuthors(10, 11, 22);

        assertEquals(10, bookAuthors.getId());
        assertEquals(11, bookAuthors.getBookId());
        assertEquals(22, bookAuthors.getAuthorId());
    }


    @DisplayName("изменение")
    @Test
    void update() {
        bookAuthorsDao.insert(new BookAuthors(10, 11, 22));
        assertEquals(11, bookAuthorsDao.getById(10).getBookId());
        assertEquals(22, bookAuthorsDao.getById(10).getAuthorId());

        BookAuthors bookAuthors = new BookAuthors(10, 33, 44);

        assertEquals(33, bookAuthors.getBookId());
        assertEquals(44, bookAuthors.getAuthorId());

        bookAuthorsDao.update(bookAuthors);

        assertEquals(33, bookAuthorsDao.getById(10).getBookId());
        assertEquals(44, bookAuthorsDao.getById(10).getAuthorId());

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
        assertEquals(bookAuthors.getId(), 3);
        assertEquals(bookAuthors.getBookId(), 33);
        assertEquals(bookAuthors.getAuthorId(), 333);
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<BookAuthors> bookAuthors = bookAuthorsDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(bookAuthors.get(i).getId() + "; " + bookAuthors.get(i).getBookId());
            assertEquals((i + 1), bookAuthors.get(i).getId());
            assertEquals(String.valueOf(i + 1) + String.valueOf(i + 1),
                    String.valueOf(bookAuthors.get(i).getBookId()));
            assertEquals(String.valueOf(i + 1) + String.valueOf(i + 1) + String.valueOf(i + 1),
                    String.valueOf(bookAuthors.get(i).getAuthorId()));
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(bookAuthorsDao.count(), 5);
    }

}