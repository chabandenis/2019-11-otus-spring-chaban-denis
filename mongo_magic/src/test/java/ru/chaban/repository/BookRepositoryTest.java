package ru.chaban.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.domain.Author;
import ru.chaban.domain.Book;
import ru.chaban.domain.Genre;
import ru.chaban.domain.Opinion;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class BookRepositoryTest {

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

    @Test
    void findAll() {
        assertEquals(true, bookRepository.findAll().size() > 0);
        int i = 0;
        for (Book book : bookRepository.findAll()) {
            assertEquals("Книга " + ++i, book.getName());

            System.out.println("Книга: " + book.getName());
            int j = 0;
            for (Author author : book.getAuthors()) {
                System.out.println("\t" + author.getName());
                assertEquals("Автор " + ++j, author.getName());
            }
            System.out.println("Книга: " + book.getName());

            j = 0;
            for (Opinion opinion : book.getComments()) {
                System.out.println("\t" + opinion.getComment());
                assertEquals("Рецензия " + ++j, opinion.getComment());
            }

            j = 0;
            for (Genre genre : book.getGenres()) {
                System.out.println("\t" + genre.getName());
                assertEquals("Жанр " + ++j, genre.getName());
            }
        }
    }

    @Test
    void findByName() {
        assertEquals(1, bookRepository.findByName("Книга 1").get(0).getId());
    }

}