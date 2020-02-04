package ru.chaban.ex05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.Author;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@DisplayName("Проверим авторов")
@JdbcTest
@Import(AuthorDaoImpl.class)
class AuthorDaoImplTest {

    @Autowired
    private AuthorDao authorDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        UUID uuid = UUID.randomUUID();
        authorDao.insert(new Author(uuid, "автор 10"));
        assertEquals(uuid, authorDao.getById(uuid).getId());
        assertEquals("автор 10", authorDao.getById(uuid).getName());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        UUID uuid = UUID.randomUUID();
        authorDao.insert(new Author(uuid, "автор 10"));
        authorDao.update(new Author(uuid, "автор 100"));
        assertEquals(uuid, authorDao.getById(uuid).getId());
        assertEquals("автор 100", authorDao.getById(uuid).getName());
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
        UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000003");
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
            assertEquals("00000000-0000-0000-0000-00000000000" + (i + 1), authors.get(i).getId().toString());
            assertEquals("автор " + (i + 1), authors.get(i).getName());
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(authorDao.count(), 5);
    }

}