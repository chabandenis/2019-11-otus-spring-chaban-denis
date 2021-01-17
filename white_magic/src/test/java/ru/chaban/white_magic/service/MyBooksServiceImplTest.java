package ru.chaban.white_magic.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.white_magic.domain.MyBooks;
import ru.chaban.white_magic.repository.*;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class MyBooksServiceImplTest {

    @Autowired
    private MyBooksRepository myBooksRepository;

    @Autowired
    private MyBooksService myBooksService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll() {
        assertEquals(true, myBooksService.findAll().size() > 0);
        int i = 0;
        for (MyBooks myBooks : myBooksService.findAll()) {
            assertEquals("Книга " + ++i, myBooks.getBook().getName());
        }
    }

    @Test
    void findByName() {
        assertEquals(1, myBooksService.findByName("Книга 1").get(0).getId());
    }

}