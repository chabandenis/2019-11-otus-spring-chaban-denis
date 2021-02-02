package ru.chaban.domain;

/*@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)*/
class GenreTest {

/*    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Genre genre = new Genre("Автор 123");
        long id = testEntityManager.persistAndGetId(genre, Long.class);
        Genre genreFromDb = testEntityManager.find(Genre.class, id);
        assertEquals(genre.getName(), genreFromDb.getName());
    }

    @Test
    void saveAndGetWithAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("123"));
        books.add(new Book("234"));

        Genre genre = new Genre("Автор 123", books);
        long id = testEntityManager.persistAndGetId(genre, Long.class);
        Genre genreFromDb = testEntityManager.find(Genre.class, id);

*//*        assertEquals(genre.getName(), genreFromDb.getName());
        assertEquals(true, Arrays.equals(books.toArray(), genreFromDb.getBooks().toArray()));*//*
    }*/
}