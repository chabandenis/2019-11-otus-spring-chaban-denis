package ru.chaban.ex05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
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
        long id = bookDao.insert(new Book("книга 10"));
        assertEquals(id, bookDao.getById(id).getId());
        assertEquals("книга 10", bookDao.getById(id).getName());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        long id = bookDao.insert(new Book("книга 10"));
        bookDao.update(new Book(id, "книга 100"));
        assertEquals(id, bookDao.getById(id).getId());
        assertEquals("книга 100", bookDao.getById(id).getName());
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
        long uuid = 3;
        Book book = bookDao.getById(uuid);
        assertEquals(book.getId(), uuid);
        assertEquals(book.getName(), "книга 3");
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<Book> books = bookDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(books.get(i).getId() + "; " + books.get(i).getName());
            assertEquals( (i + 1), books.get(i).getId());
            assertEquals("книга " + (i + 1), books.get(i).getName());
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(bookDao.count(), 5);
    }
}