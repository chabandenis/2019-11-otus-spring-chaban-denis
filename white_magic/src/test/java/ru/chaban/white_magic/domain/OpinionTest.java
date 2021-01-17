package ru.chaban.white_magic.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class OpinionTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Opinion opinion = new Opinion("мнение 123", new Book("zzz"));
        long id = testEntityManager.persistAndGetId(opinion, Long.class);
        Opinion opinionFromDb = testEntityManager.find(Opinion.class, id);
        assertEquals(opinionFromDb.getComment(), opinion.getComment());
        assertEquals(id, opinion.getId());
    }
}