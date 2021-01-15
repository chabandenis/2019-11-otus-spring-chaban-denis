package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Book;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(BookRepositoryJpaImpl.class)
class BookRepositoryJpaImplTest {

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;


    @Test
    void save() {
        Book book = new Book("XXX");
        book = bookRepositoryJpa.save(book);
        assertEquals(book.getName(), bookRepositoryJpa.findById(book.getId()).get().getName());
    }

    @Test
    void findById() {
        Optional<Book> book = bookRepositoryJpa.findById(1);
        assertEquals("Книга 1", book.get().getName());
    }

    @Test
    void deleteById() {
        /*
        Book book = bookRepositoryJpa.save(new Book("555"));
        int cnt = bookRepositoryJpa.findAll().size();
        bookRepositoryJpa.deleteById(book.getId());
        assertEquals(cnt, bookRepositoryJpa.findAll().size() + 1);
         */
    }

}