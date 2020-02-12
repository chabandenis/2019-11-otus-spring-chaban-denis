package ru.chaban.ex05.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.Author;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DisplayName("Проверим авторов")
@JdbcTest

class AuthorDaoImplTest {
/*
    @Autowired
    private AuthorDao authorDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        long id = authorDao.insert(new Author("автор 10"));
        assertEquals(id, authorDao.getById(id).getId());
        assertEquals("автор 10", authorDao.getById(id).getName());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        long id = authorDao.insert(new Author("автор 10"));
        authorDao.update(new Author(id, "автор 100"));
        assertEquals(id, authorDao.getById(id).getId());
        assertEquals("автор 100", authorDao.getById(id).getName());
    }

    @DisplayName("удаление")
    @Test
    void deleteById() {
        assertEquals(authorDao.count(), 5);
        authorDao.deleteById(5);
        assertEquals(authorDao.count(), 4);
    }

    @DisplayName("по ID")
    @Test
    void getById() {
        long uuid = 3;
        Author author = authorDao.getById(uuid);
        assertEquals(author.getId(), uuid);
        assertEquals(author.getName(), "автор 3");
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<Author> authors = authorDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(authors.get(i).getId() + "; " + authors.get(i).getName());
            assertEquals((i + 1), authors.get(i).getId());
            assertEquals("автор " + (i + 1), authors.get(i).getName());
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(authorDao.count(), 5);
    }


 */
}