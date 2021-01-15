package ru.chaban.whiteMagic.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.whiteMagic.domain.Opinion;
import ru.chaban.whiteMagic.repository.OpinionRepositoryJpa;
import ru.chaban.whiteMagic.repository.OpinionRepositoryJpaImpl;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({OpinionRepositoryJpaImpl.class, OpinionServiceImpl.class})
class OpinionServiceImplTest {

    @Autowired
    private OpinionRepositoryJpa opinionRepositoryJpa;

    @Autowired
    private OpinionService opinionService;

    @Test
    void findAll() {
        assertEquals(true, opinionService.findAll().size() > 0);
        int i = 0;
        int j = 0;
        int k = 1;
        for (Opinion opinion : opinionService.findAll()) {
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
        assertEquals(1, opinionService.findByName("Рецензия 1").get(0).getId());
    }

}