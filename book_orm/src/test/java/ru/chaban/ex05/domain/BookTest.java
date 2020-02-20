package ru.chaban.ex05.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Book book = new Book("Автор 123");
        long id = testEntityManager.persistAndGetId(book, Long.class);
        Book bookFromDb = testEntityManager.find(Book.class, id);
        assertEquals(bookFromDb.getName(), book.getName());
    }

    @Test
    void saveAndGetWithAll() {
        Book book = new Book("ttt");
        book.getComments().add(new Opinion("Бла бла бла 1", book));
        book.getComments().add(new Opinion("Бла бла бла 2", book));
        book.getComments().add(new Opinion("Бла бла бла 3", book));

        book.getAuthors().add(new Author("я1", Arrays.asList(book)));
        book.getAuthors().add(new Author("я2", Arrays.asList(book)));
        book.getAuthors().add(new Author("я3", Arrays.asList(book)));

        book.getGenres().add(new Genre("Жанр1", Arrays.asList(book)));
        book.getGenres().add(new Genre("Жанр2", Arrays.asList(book)));
        book.getGenres().add(new Genre("Жанр3", Arrays.asList(book)));

        long id = testEntityManager.persistAndGetId(book, Long.class);
        Book bookFromDb = testEntityManager.find(Book.class, id);
        assertEquals(bookFromDb.getName(), book.getName());

    }



}