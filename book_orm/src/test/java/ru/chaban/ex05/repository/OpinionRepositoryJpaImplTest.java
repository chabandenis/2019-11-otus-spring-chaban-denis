package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.Opinion;

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
    void findAll() {
        assertEquals(true, opinionRepositoryJpa.findAll().size() > 0);
        int i = 0;
        int j = 0;
        int k = 1;
        for (Opinion opinion : opinionRepositoryJpa.findAll()) {
            if (i == 5) {
                i = 0;
            }
            assertEquals("Рецензия " + ++i, opinion.getComment());
            j++;

            System.out.println(opinion.getComment() + "; " + opinion.getBook_id().getName());
            assertEquals("Книга " + k, opinion.getBook_id().getName());
            if (j == 5) {
                k++;
                j = 0;
            }
        }

    }

    @Test
    void findByName() {
        assertEquals(1, opinionRepositoryJpa.findByName("Рецензия 1").get(0).getId());
    }

    @Test
    void updateNameById() {
        opinionRepositoryJpa.updateNameById(2, "222");
        assertEquals("222", opinionRepositoryJpa.findById(2).get().getComment());
    }

    @Test
    void deleteById() {
        int cnt = opinionRepositoryJpa.findAll().size();
        opinionRepositoryJpa.deleteById(2);
        assertEquals(cnt, opinionRepositoryJpa.findAll().size()+1);
    }
}