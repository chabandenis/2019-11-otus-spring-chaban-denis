package ru.chaban.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.domain.Book;
import ru.chaban.domain.MyBooks;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class MyBooksRepositoryJpaTest {

    @Autowired
    private MyBooksRepository myBooksRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void save() {
        MyBooks myBooks = new MyBooks(new Book("XXX"));
        myBooks = myBooksRepository.save(myBooks);
        assertEquals(myBooks.getBook().getName(), myBooksRepository.findById(myBooks.getId()).get().getBook().getName());
    }

    @Test
    void findById() {
        Optional<MyBooks> myBooks = myBooksRepository.findById(1);
        assertEquals("Книга 1", myBooks.get().getBook().getName());
    }

    @Test
    void deleteById() {
        Book book = new Book("123");
        bookRepository.save(book);

        MyBooks myBooks = new MyBooks(book);
        myBooksRepository.save(myBooks);

        int cnt = myBooksRepository.findAll().size();
        myBooksRepository.deleteById(myBooks.getId());
        assertEquals(cnt, myBooksRepository.findAll().size() + 1);
    }

    @Test
    void findAll() {
        assertEquals(true, myBooksRepository.findAll().size() > 0);
        int i = 0;
        for (MyBooks myBooks : myBooksRepository.findAll()) {
            assertEquals("Книга " + ++i, myBooks.getBook().getName());
        }
    }

    @Test
    void findByName() {
        assertEquals(1, myBooksRepository.findByBook_Name("Книга 1").get(0).getId());
    }
}