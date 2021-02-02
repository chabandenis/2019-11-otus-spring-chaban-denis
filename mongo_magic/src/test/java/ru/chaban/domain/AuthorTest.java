package ru.chaban.domain;

/*
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
*/
class AuthorTest {
/*

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Author author = new Author("Автор 123");
        long id = testEntityManager.persistAndGetId(author, Long.class);
        Author authorFromDb = testEntityManager.find(Author.class, id);
        assertEquals(authorFromDb.getName(), author.getName());
    }

    @Test
    void saveAndGetWithBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("TestBook111"));
        books.add(new Book("TestBook222"));

        Author author = new Author("Автор 123", books);
        long id = testEntityManager.persistAndGetId(author, Long.class);
        Author authorFromDb = testEntityManager.find(Author.class, id);
        assertEquals(authorFromDb.getName(), author.getName());

*/
/*
        assertEquals(true, Arrays.equals(books.toArray(), authorFromDb.getBooks().toArray()));
*//*

    }
*/

}