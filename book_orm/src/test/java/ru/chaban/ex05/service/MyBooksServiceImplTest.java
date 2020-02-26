package ru.chaban.ex05.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.ex05.repository.MyBooksRepositoryJpa;
import ru.chaban.ex05.repository.MyBooksRepositoryJpaImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(MyBooksRepositoryJpaImpl.class)
class MyBooksServiceImplTest {

    @Autowired
    private MyBooksRepositoryJpa myBooksRepositoryJpa;


    @Test
    void findAll() {
        /*
        assertEquals(true, myBooksRepositoryJpa.findAll().size() > 0);
        int i = 0;
        for (MyBooks myBooks : myBooksRepositoryJpa.findAll()) {
            assertEquals("Книга " + ++i, myBooks.getBook().getName());
        }

         */
    }

    @Test
    void findByName() {
        //assertEquals(1, myBooksRepositoryJpa.findByName("Книга 1").get(0).getId());
    }

    @Test
    @Transactional
    void updateNameById() {/*
        myBooksRepositoryJpa.updateNameById(2, new Book("bbbb"));
        assertEquals("bbbb", myBooksRepositoryJpa.findById(2).get().getBook().getName());
        */
    }

}