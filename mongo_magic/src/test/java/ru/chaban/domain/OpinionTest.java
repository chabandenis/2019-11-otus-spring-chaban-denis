package ru.chaban.domain;

/*
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
*/
class OpinionTest {
/*
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
*/
}