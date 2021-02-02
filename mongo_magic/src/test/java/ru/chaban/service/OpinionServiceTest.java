package ru.chaban.service;

import org.springframework.beans.factory.annotation.Autowired;

/*@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)*/
//@Import(OpinionRepository.class)
class OpinionServiceTest {
    @Autowired
    private OpinionService opinionService;

/*
    @Test
    @Transactional
    void del() {
        var cnt = opinionService.count();
        assertEquals(true, cnt > 0);
        opinionService.customDelete();
        cnt = opinionService.count();
        assertEquals(true, cnt == 0);
    }
*/
}