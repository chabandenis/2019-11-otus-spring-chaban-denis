package ru.chaban.ex05.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.chaban.ex05.domain.Genre;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DisplayName("Проверим жанры")
@JdbcTest
//@Import(GenreDaoImpl.class)
class GenreDaoImplTest {
/*
    @Autowired
    private GenreDao genreDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        long id = genreDao.insert(new Genre("жанр 10"));
        assertEquals(id, genreDao.getById(id).getId());
        assertEquals("жанр 10", genreDao.getById(id).getName());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        long id = genreDao.insert(new Genre("жанр 10"));
        genreDao.update(new Genre(id, "жанр 100"));
        assertEquals(id, genreDao.getById(id).getId());
        assertEquals("жанр 100", genreDao.getById(id).getName());
    }

    @DisplayName("удаление")
    @Test
    void deleteById() {
        assertEquals(genreDao.count(), 5);
        genreDao.deleteById(5);
        assertEquals(genreDao.count(), 4);
    }

    @DisplayName("по ID")
    @Test
    void getById() {
        long uuid = 03;
        Genre genre = genreDao.getById(uuid);
        assertEquals(uuid, genre.getId());
        assertEquals(genre.getName(), "жанр 3");
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<Genre> genres = genreDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(genres.get(i).getId() + "; " + genres.get(i).getName());
            assertEquals((i + 1), genres.get(i).getId());
            assertEquals("жанр " + (i + 1), genres.get(i).getName());
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(genreDao.count(), 5);
    }

 */
}