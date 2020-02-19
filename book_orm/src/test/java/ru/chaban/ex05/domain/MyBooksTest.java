package ru.chaban.ex05.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class MyBooksTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Book book = new Book("Автор 123");
        long bookId = testEntityManager.persistAndGetId(book, Long.class);

        MyBooks myBooks = new MyBooks(bookId);
        long id = testEntityManager.persistAndGetId(myBooks, Long.class);
        MyBooks myBooksFromDb = testEntityManager.find(MyBooks.class, id);
        assertEquals(myBooksFromDb.getBookId(), myBooks.getBookId());
    }
}