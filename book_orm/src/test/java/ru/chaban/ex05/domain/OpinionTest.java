package ru.chaban.ex05.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class OpinionTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Opinion opinion = new Opinion("мнение 123", 1);
        long id = testEntityManager.persistAndGetId(opinion, Long.class);
        Opinion opinionFromDb = testEntityManager.find(Opinion.class, id);
        assertEquals(opinionFromDb.getComment(), opinion.getComment());
    }
}