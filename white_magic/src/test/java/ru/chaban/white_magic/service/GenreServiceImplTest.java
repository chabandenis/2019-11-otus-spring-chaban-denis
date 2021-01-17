package ru.chaban.white_magic.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.white_magic.domain.Book;
import ru.chaban.white_magic.domain.Genre;
import ru.chaban.white_magic.repository.GenreRepository;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class GenreServiceImplTest {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreService genreService;

    @Test
    void findAll() {
        assertEquals(true, genreService.findAll().size() > 0);
        int i = 0;
        for (Genre genre : genreService.findAll()) {
            assertEquals("Жанр " + ++i, genre.getName());

            System.out.println("" + genre.getName());
            int j = 0;
            for (Book book : genre.getBooks()) {
                System.out.println("\t" + book.getName());
                assertEquals("Книга " + ++j, book.getName());
            }
        }
    }

    @Test
    void findByName() {
        assertEquals(1, genreService.findByName("Жанр 1").get(0).getId());
    }

}