package ru.chaban.white_magic.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.white_magic.domain.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class GenreRepositoryJpaImplTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    void save() {
        Genre genre = new Genre("XXX");
        genre = genreRepository.save(genre);
        assertEquals(genre.getName(), genreRepository.findById(genre.getId()).get().getName());
    }

    @Test
    void findById() {
        Optional<Genre> genre = genreRepository.findById(1);
        assertEquals("Жанр 1", genre.get().getName());
    }

    @Test
    void deleteById() {
        Genre genre = new Genre("YYY", new ArrayList<>());
        genreRepository.save(genre);
        int cnt = genreRepository.findAll().size();
        genreRepository.deleteById(genre.getId());
        assertEquals(cnt, genreRepository.findAll().size() + 1);
    }
}