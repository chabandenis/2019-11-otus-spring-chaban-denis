package ru.chaban.repository;

/*@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)*/
class OpinionRepositoryTest {
/*

    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void save() {
        Opinion opinion = new Opinion("XXX", new Book("YYY"));
        opinion = opinionRepository.save(opinion);
        assertEquals(opinion.getComment(), opinionRepository.findById(opinion.getId()).get().getComment());
    }

    @Test
    void findById() {
        Optional<Opinion> author = opinionRepository.findById(1);
        assertEquals("Рецензия 1", author.get().getComment());
    }

    @Test
    void deleteById() {
        Book book = new Book("223");
        bookRepository.save(book);
        Opinion opinion = new Opinion("2222", book);
        opinionRepository.save(opinion);
        int cnt = opinionRepository.findAll().size();
        opinionRepository.deleteById(opinion.getId());
        assertEquals(cnt, opinionRepository.findAll().size() + 1);
    }

    @Test
    void findAll() {
        assertEquals(true, opinionRepository.findAll().size() > 0);
        int i = 0;
        int j = 0;
        int k = 1;
        for (Opinion opinion : opinionRepository.findAll()) {
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
        assertEquals(1, opinionRepository.findByComment("Рецензия 1").get(0).getId());
    }
*/

}