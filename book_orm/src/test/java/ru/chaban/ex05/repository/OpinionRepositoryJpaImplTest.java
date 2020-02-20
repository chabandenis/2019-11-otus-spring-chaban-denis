package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Author;
import ru.chaban.ex05.domain.Opinion;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(OpinionRepositoryJpaImpl.class)
class OpinionRepositoryJpaImplTest {

    @Autowired
    private OpinionRepositoryJpa opinionRepositoryJpa;

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        assertEquals(true, opinionRepositoryJpa.findAll().size() > 0);
        int i=0;
        for (Opinion opinion : opinionRepositoryJpa.findAll()) {
            assertEquals("Автор "+ ++i, opinion.getComment());
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