package ru.chaban.ex05.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.repository.GenreRepositoryJpa;
import ru.chaban.ex05.repository.GenreRepositoryJpaImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(GenreRepositoryJpaImpl.class)
class GenreServiceImplTest {

    @Autowired
    private GenreRepositoryJpa genreRepositoryJpa;

    @Test
    void findAll() {
        /*
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
*/
    }

    @Test
    void findByName() {
        // assertEquals(1, genreRepositoryJpa.findByName("Жанр 1").get(0).getId());
    }

    @Test
    void updateNameById() {
        /*
        genreRepositoryJpa.updateNameById(2, "222");
        assertEquals("222", genreRepositoryJpa.findById(2).get().getName());

         */
    }

}