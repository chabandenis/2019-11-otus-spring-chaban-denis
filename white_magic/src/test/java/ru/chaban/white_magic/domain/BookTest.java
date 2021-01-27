package ru.chaban.white_magic.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
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

        List<Opinion> opinions = new ArrayList<>();
        opinions.add(new Opinion("Бла бла бла 1", book));
        opinions.add(new Opinion("Бла бла бла 2", book));
        opinions.add(new Opinion("Бла бла бла 3", book));
        book.setComments(opinions);

        List<Author> authors = new ArrayList<>();
        authors.add(new Author("я1", Arrays.asList(book)));
        authors.add(new Author("я2", Arrays.asList(book)));
        authors.add(new Author("я3", Arrays.asList(book)));
        book.setAuthors(authors);

        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre("Жанр1", Arrays.asList(book)));
        genres.add(new Genre("Жанр2", Arrays.asList(book)));
        genres.add(new Genre("Жанр3", Arrays.asList(book)));
        book.setGenres(genres);

        long id = testEntityManager.persistAndGetId(book, Long.class);
        Book bookFromDb = testEntityManager.find(Book.class, id);

        assertEquals(bookFromDb.getName(), book.getName());
        assertEquals(true, Arrays.equals(opinions.toArray(), bookFromDb.getComments().toArray()));
        assertEquals(true, Arrays.equals(authors.toArray(), bookFromDb.getAuthors().toArray()));
        assertEquals(true, Arrays.equals(genres.toArray(), bookFromDb.getGenres().toArray()));
        assertEquals(true, Arrays.equals(genres.toArray(), bookFromDb.getGenres().toArray()));
    }


}