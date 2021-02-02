package ru.chaban.domain;

/*
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
*/
class MyBooksTest {
/*    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Book book = new Book("Автор 123");
        MyBooks myBooks = new MyBooks(book);
        long id = testEntityManager.persistAndGetId(myBooks, Long.class);
        MyBooks myBooksFromDb = testEntityManager.find(MyBooks.class, id);
        assertEquals(myBooksFromDb.getBook().getName(), myBooks.getBook().getName());
        assertEquals(myBooksFromDb.getId(), myBooks.getId());
    }*/
}