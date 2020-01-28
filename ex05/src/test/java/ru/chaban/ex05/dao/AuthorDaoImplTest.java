package ru.chaban.ex05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.Author;

import static org.junit.Assert.assertEquals;

@DisplayName("Проверим авторов")
@JdbcTest
@Import(AuthorDaoImpl.class)
class AuthorDaoImplTest {

    @Autowired
    private AuthorDao authorDao;

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getById() {
    }

    @DisplayName("Все ли загружены?")
    @Test
    void getAll() {
        System.out.println("QQQQ");
        for (Author author : authorDao.getAll()){
            System.out.println("Значения: " +author.getId() + "; " + author.getName());
        }
        assertEquals(1, 2);
    }

    @Test
    void count() {
    }
}