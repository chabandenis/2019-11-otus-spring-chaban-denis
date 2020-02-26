package ru.chaban.ex05.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.Opinion;
import ru.chaban.ex05.repository.OpinionRepositoryJpa;
import ru.chaban.ex05.repository.OpinionRepositoryJpaImpl;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(OpinionRepositoryJpaImpl.class)
class OpinionServiceImplTest {

    @Autowired
    private OpinionRepositoryJpa opinionRepositoryJpa;

    @Test
    void findAll() {
        /*
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
*/
    }

    @Test
    void findByName() {
       // assertEquals(1, opinionRepositoryJpa.findByName("Рецензия 1").get(0).getId());
    }

    @Test
    void updateNameById() {
        /*
        opinionRepositoryJpa.updateNameById(2, "222");
        assertEquals("222", opinionRepositoryJpa.findById(2).get().getComment());

         */
    }

}