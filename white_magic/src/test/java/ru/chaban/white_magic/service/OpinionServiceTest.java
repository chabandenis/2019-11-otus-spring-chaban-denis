package ru.chaban.white_magic.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.white_magic.repository.OpinionRepository;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//@Import(OpinionRepository.class)
class OpinionServiceTest {
    @Autowired
    private OpinionService opinionService;

    @Test
    @Transactional
    void del() {
        var cnt = opinionService.count();
        assertEquals(true, cnt > 0);
        opinionService.customDelete();
        cnt = opinionService.count();
        assertEquals(true, cnt == 0);
    }
}