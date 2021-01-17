package ru.chaban.white_magic.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.white_magic.domain.Author;
import ru.chaban.white_magic.domain.Book;
import ru.chaban.white_magic.repository.AuthorRepository;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AuthorServiceImplTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void findAll() {

        assertEquals(true, authorService.findAll().size() > 0);
        int i = 0;
        for (Author author : authorService.findAll()) {
            assertEquals("Автор " + ++i, author.getName());

            System.out.println("Автор: " + author.getName());
            int j = 0;
            for (Book book : author.getBooks()) {
                System.out.println("\t" + book.getName());
                assertEquals("Книга " + ++j, book.getName());
            }
        }
    }

    @Test
    void findByName() {
        assertEquals(1, authorService.findByName("Автор 1").get(0).getId());
    }

}