package ru.chaban.whiteMagic.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.whiteMagic.domain.Book;
import ru.chaban.whiteMagic.domain.Opinion;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(OpinionRepositoryJpaImpl.class)
class OpinionRepositoryJpaImplTest {

    @Autowired
    private OpinionRepositoryJpa opinionRepositoryJpa;

    @Test
    void save() {
        Opinion opinion = new Opinion("XXX", new Book("YYY"));
        opinion = opinionRepositoryJpa.save(opinion);
        assertEquals(opinion.getComment(), opinionRepositoryJpa.findById(opinion.getId()).get().getComment());
    }

    @Test
    void findById() {
        Optional<Opinion> author = opinionRepositoryJpa.findById(1);
        assertEquals("Рецензия 1", author.get().getComment());
    }

    @Test
    void deleteById() {
        /*
        int cnt = opinionRepositoryJpa.findAll().size();
        opinionRepositoryJpa.deleteById(2);
        assertEquals(cnt, opinionRepositoryJpa.findAll().size() + 1);

         */
    }
}