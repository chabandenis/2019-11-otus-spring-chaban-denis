package ru.chaban.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class MyBooksTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Book book = new Book("Автор 123");
        MyBooks myBooks = new MyBooks(book);
        long id = testEntityManager.persistAndGetId(myBooks, Long.class);
        MyBooks myBooksFromDb = testEntityManager.find(MyBooks.class, id);
        assertEquals(myBooksFromDb.getBook().getName(), myBooks.getBook().getName());
        assertEquals(myBooksFromDb.getId(), myBooks.getId());
    }
}