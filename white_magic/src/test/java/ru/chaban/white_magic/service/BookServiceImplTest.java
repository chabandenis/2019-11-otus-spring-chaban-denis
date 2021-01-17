package ru.chaban.white_magic.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.white_magic.domain.Author;
import ru.chaban.white_magic.domain.Book;
import ru.chaban.white_magic.domain.Genre;
import ru.chaban.white_magic.domain.Opinion;
import ru.chaban.white_magic.repository.BookRepository;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class BookServiceImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    void findAll() {
        assertEquals(true, bookService.findAll().size() > 0);
        int i = 0;
        for (Book book : bookService.findAll()) {
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
        assertEquals(1, bookService.findByName("Книга 1").get(0).getId());
    }

}