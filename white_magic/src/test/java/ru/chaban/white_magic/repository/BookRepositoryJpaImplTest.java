package ru.chaban.white_magic.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.white_magic.domain.Book;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class BookRepositoryJpaImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void save() {
        Book book = new Book("XXX");
        book = bookRepository.save(book);
        assertEquals(book.getName(), bookRepository.findById(book.getId()).get().getName());
    }

    @Test
    void findById() {
        Optional<Book> book = bookRepository.findById(1);
        assertEquals("Книга 1", book.get().getName());
    }

    @Test
    void deleteById() {
        Book book = bookRepository.save(new Book("555"));
        int cnt = bookRepository.findAll().size();
        bookRepository.deleteById(book.getId());
        assertEquals(cnt, bookRepository.findAll().size() + 1);
    }

}