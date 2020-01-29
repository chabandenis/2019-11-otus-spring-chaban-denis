package ru.chaban.ex05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.Author;
import ru.chaban.ex05.domain.Book;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DisplayName("Проверим авторов")
@JdbcTest
@Import(BookDaoImpl.class)
class BookDaoImplTest {

    @Autowired
    private BookDao bookDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        bookDao.insert(new Book(10, "книга 10"));
        assertEquals(10, bookDao.getById(10).getId());
        assertEquals("книга 10", bookDao.getById(10).getName());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        bookDao.insert(new Book(10, "книга 10"));
        bookDao.update(new Book(10, "книга 100"));
        assertEquals(10, bookDao.getById(10).getId());
        assertEquals("книга 100", bookDao.getById(10).getName());
    }

    @DisplayName("удаление")
    @Test
    void deleteById() {
        assertEquals(bookDao.count(), 5);
        bookDao.deleteById(5);
        assertEquals(bookDao.count(), 4);
    }

    @DisplayName("по ID")
    @Test
    void getById() {
        Book book = bookDao.getById(3);
        assertEquals(book.getId(), 3);
        assertEquals(book.getName(), "книга 3");
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<Book> books = bookDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(books.get(i).getId() + "; " + books.get(i).getName());
            assertEquals((i + 1), books.get(i).getId());
            assertEquals("книга " + (i + 1), books.get(i).getName());
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(bookDao.count(), 5);
    }
}