package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
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
    void deleteById() {
        /*
        int cnt = genreRepositoryJpa.findAll().size();
        genreRepositoryJpa.deleteById(2);
        assertEquals(cnt, genreRepositoryJpa.findAll().size() + 1);
         */
    }
}