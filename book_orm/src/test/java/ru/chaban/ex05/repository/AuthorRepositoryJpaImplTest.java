package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Author;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(AuthorRepositoryJpaImpl.class)
class AuthorRepositoryJpaImplTest {

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        assertEquals(true, authorRepositoryJpa.findAll().size() > 0);
        int i = 0;
        for (Author author : authorRepositoryJpa.findAll()) {
            assertEquals("Автор " + ++i, author.getName());
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