package ru.chaban.whiteMagic.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.whiteMagic.domain.MyBooks;
import ru.chaban.whiteMagic.repository.BookRepositoryJpa;
import ru.chaban.whiteMagic.repository.BookRepositoryJpaImpl;
import ru.chaban.whiteMagic.repository.MyBooksRepositoryJpa;
import ru.chaban.whiteMagic.repository.MyBooksRepositoryJpaImpl;

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