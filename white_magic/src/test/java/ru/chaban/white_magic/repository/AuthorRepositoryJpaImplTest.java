package ru.chaban.white_magic.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.white_magic.domain.Author;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AuthorRepositoryJpaImplTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void save() {
        Author author = new Author("XXX");
        author = authorRepository.save(author);
        assertEquals(author.getName(), authorRepository.findById(author.getId()).get().getName());
    }

    @Test
    void findById() {
        Optional<Author> author = authorRepository.findById(1l);
        assertEquals("Автор 1", author.get().getName());
    }

    @Test
    void deleteById() {
        int cnt = authorRepository.findAll().size();
        authorRepository.deleteById(6L);
        assertEquals(cnt, authorRepository.findAll().size() + 1);
    }
}