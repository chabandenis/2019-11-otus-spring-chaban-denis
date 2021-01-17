package ru.chaban.white_magic.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaban.white_magic.domain.Opinion;
import ru.chaban.white_magic.repository.OpinionRepository;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class OpinionServiceImplTest {

    @Autowired
    private OpinionRepository opinionRepository;

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