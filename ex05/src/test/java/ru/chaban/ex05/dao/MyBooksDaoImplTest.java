package ru.chaban.ex05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.Genre;
import ru.chaban.ex05.domain.MyBooks;

import java.util.List;

import static org.junit.Assert.assertEquals;


@DisplayName("мои книги")
@JdbcTest
@Import(MyBooksDaoImpl.class)
class MyBooksDaoImplTest {

    @Autowired
    private MyBooksDao myBooksDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        myBooksDao.insert(new MyBooks(10, 1));
        assertEquals(10, myBooksDao.getById(10).getId());
        assertEquals(1, myBooksDao.getById(10).getMyBookId());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        myBooksDao.insert(new MyBooks(10, 10));
        myBooksDao.update(new MyBooks(10, 100));
        assertEquals(10, myBooksDao.getById(10).getId());
        assertEquals(100, myBooksDao.getById(10).getMyBookId());
    }

    @DisplayName("удаление")
    @Test
    void deleteById() {
        assertEquals(myBooksDao.count(), 3);
        myBooksDao.deleteById(2);
        assertEquals(myBooksDao.count(), 2);
    }

    @DisplayName("по ID")
    @Test
    void getById() {
        MyBooks genre = myBooksDao.getById(3);
        assertEquals(genre.getId(), 3);
        assertEquals(genre.getMyBookId(), 3);
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<MyBooks> genres = myBooksDao.getAll();
        for (int i = 0; i < 3; i++) {
            System.out.println(genres.get(i).getId() + "; " + genres.get(i).getMyBookId());
            assertEquals((i + 1), genres.get(i).getId());
            assertEquals((i + 1), genres.get(i).getMyBookId());
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(myBooksDao.count(), 3);
    }

}