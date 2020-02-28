package ru.chaban.ex05.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.MyBooks;
import ru.chaban.ex05.repository.BookRepositoryJpa;
import ru.chaban.ex05.repository.BookRepositoryJpaImpl;
import ru.chaban.ex05.repository.MyBooksRepositoryJpa;
import ru.chaban.ex05.repository.MyBooksRepositoryJpaImpl;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({MyBooksRepositoryJpaImpl.class, MyBooksServiceImpl.class, BookRepositoryJpaImpl.class})
class MyBooksServiceImplTest {

    @Autowired
    private MyBooksRepositoryJpa myBooksRepositoryJpa;

    @Autowired
    private MyBooksService myBooksService;

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

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