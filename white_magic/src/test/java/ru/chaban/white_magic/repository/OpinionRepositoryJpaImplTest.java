package ru.chaban.white_magic.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.white_magic.domain.Book;
import ru.chaban.white_magic.domain.Opinion;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class OpinionRepositoryJpaImplTest {

    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void save() {
        Opinion opinion = new Opinion("XXX", new Book("YYY"));
        opinion = opinionRepository.save(opinion);
        assertEquals(opinion.getComment(), opinionRepository.findById(opinion.getId()).get().getComment());
    }

    @Test
    void findById() {
        Optional<Opinion> author = opinionRepository.findById(1);
        assertEquals("Рецензия 1", author.get().getComment());
    }

    @Test
    void deleteById() {
        Book book = new Book("223");
        bookRepository.save(book);
        Opinion opinion = new Opinion("2222", book);
        opinionRepository.save(opinion);
        int cnt = opinionRepository.findAll().size();
        opinionRepository.deleteById(opinion.getId());
        assertEquals(cnt, opinionRepository.findAll().size() + 1);
    }
}