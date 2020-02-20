package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.Genre;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(GenreRepositoryJpaImpl.class)
class GenreRepositoryJpaImplTest {

    @Autowired
    private GenreRepositoryJpa genreRepositoryJpa;

    @Test
    void save() {
        Genre genre = new Genre("XXX");
        genre = genreRepositoryJpa.save(genre);
        assertEquals(genre.getName(), genreRepositoryJpa.findById(genre.getId()).get().getName());
    }

    @Test
    void findById() {
        Optional<Genre> genre = genreRepositoryJpa.findById(1);
        assertEquals("Жанр 1", genre.get().getName());
    }

    @Test
    void findAll() {
        assertEquals(true, genreRepositoryJpa.findAll().size() > 0);
        int i = 0;
        for (Genre genre : genreRepositoryJpa.findAll()) {
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
    }

    @Test
    void updateNameById() {
    }

    @Test
    void deleteById() {
    }
}