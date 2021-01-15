package ru.chaban.ex05.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.Genre;
import ru.chaban.ex05.repository.GenreRepositoryJpa;
import ru.chaban.ex05.repository.GenreRepositoryJpaImpl;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({GenreRepositoryJpaImpl.class, GenreServiceImpl.class})
class GenreServiceImplTest {

    @Autowired
    private GenreRepositoryJpa genreRepositoryJpa;

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