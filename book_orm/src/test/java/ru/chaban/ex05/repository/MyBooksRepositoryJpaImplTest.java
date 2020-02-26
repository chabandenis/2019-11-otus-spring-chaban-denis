package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.MyBooks;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(MyBooksRepositoryJpaImpl.class)
class MyBooksRepositoryJpaImplTest {

    @Autowired
    private MyBooksRepositoryJpa myBooksRepositoryJpa;

    @Test
    void save() {
        MyBooks myBooks = new MyBooks(new Book("XXX"));
        myBooks = myBooksRepositoryJpa.save(myBooks);
        assertEquals(myBooks.getBook().getName(), myBooksRepositoryJpa.findById(myBooks.getId()).get().getBook().getName());
    }

    @Test
    void findById() {
        Optional<MyBooks> myBooks = myBooksRepositoryJpa.findById(1);
        assertEquals("Книга 1", myBooks.get().getBook().getName());
    }

    @Test
    void deleteById() {
        /*
        int cnt = myBooksRepositoryJpa.findAll().size();
        myBooksRepositoryJpa.deleteById(2);
        assertEquals(cnt, myBooksRepositoryJpa.findAll().size() + 1);

         */
    }
}