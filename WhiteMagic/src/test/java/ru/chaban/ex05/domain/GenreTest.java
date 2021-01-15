package ru.chaban.ex05.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class GenreTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Genre genre = new Genre("Автор 123");
        long id = testEntityManager.persistAndGetId(genre, Long.class);
        Genre genreFromDb = testEntityManager.find(Genre.class, id);
        assertEquals(genre.getName(), genreFromDb.getName());
    }

    @Test
    void saveAndGetWithAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("123"));
        books.add(new Book("234"));

        Genre genre = new Genre("Автор 123", books);
        long id = testEntityManager.persistAndGetId(genre, Long.class);
        Genre genreFromDb = testEntityManager.find(Genre.class, id);

        assertEquals(genre.getName(), genreFromDb.getName());
        assertEquals(true, Arrays.equals(books.toArray(), genreFromDb.getBooks().toArray()));
    }
}