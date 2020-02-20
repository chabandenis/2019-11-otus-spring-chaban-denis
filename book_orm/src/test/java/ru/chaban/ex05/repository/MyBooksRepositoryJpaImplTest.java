package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Author;
import ru.chaban.ex05.domain.MyBooks;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(MyBooksRepositoryJpaImpl.class)
class MyBooksRepositoryJpaImplTest {

    @Autowired
    private MyBooksRepositoryJpa myBooksRepositoryJpa;

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        assertEquals(true, myBooksRepositoryJpa.findAll().size() > 0);
        int i=0;
        for (MyBooks myBooks : myBooksRepositoryJpa.findAll()) {
            assertEquals("Автор "+ ++i, myBooks.getBook().getName());
        }
    }

    @Test
    void findByName() {
    }

    @Test
    void updateNameById() {
    }

    @Test
    void deleteById() {
    }
}