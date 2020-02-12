package ru.chaban.ex05.models;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import static org.junit.Assert.assertEquals;

@DisplayName("Проверим связь книги и жанров")
@JdbcTest
//@Import(BookGenresDaoImpl.class)
class BookCommentsDaoImplTest {
    /*
    @Autowired
    private BookGenresDao bookGenresDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        long uuidBook = 1;
        long uuidBookNew = 2;

        long idBookGenre = bookGenresDao.insert(new BookComments(uuidBook, uuidBookNew));

        assertEquals(uuidBook, bookGenresDao.getById(idBookGenre).getBookId());
        assertEquals(uuidBookNew, bookGenresDao.getById(idBookGenre).getGenreId());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        long uuidBook = 11;
        long uuidGenre = 22;

        long uuidBookNew = 33;
        long uuidGenreNew = 44;

        long bookGenre = bookGenresDao.insert(new BookComments(uuidBook, uuidGenre));
        assertEquals(uuidBook, bookGenresDao.getById(bookGenre).getBookId());
        assertEquals(uuidGenre, bookGenresDao.getById(bookGenre).getGenreId());

        BookComments bookComments = new BookComments(bookGenre, uuidBookNew, uuidGenreNew);

        assertEquals(uuidBookNew, bookComments.getBookId());
        assertEquals(uuidGenreNew, bookComments.getGenreId());

        bookGenresDao.update(bookComments);

        assertEquals(uuidBookNew, bookGenresDao.getById(bookGenre).getBookId());
        assertEquals(uuidGenreNew, bookGenresDao.getById(bookGenre).getGenreId());

    }

    @DisplayName("удаление")
    @Test
    void deleteById() {
        assertEquals(bookGenresDao.count(), 5);
        bookGenresDao.deleteById(5);
        assertEquals(bookGenresDao.count(), 4);
    }

    @DisplayName("по ID")
    @Test
    void getById() {
        BookComments bookComments = bookGenresDao.getById(3);
        assertEquals(bookComments.getId(), 3);
        assertEquals(bookComments.getBookId(), 3);
        assertEquals(bookComments.getGenreId(), 3);
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<BookComments> bookGenres = bookGenresDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(bookGenres.get(i).getId() + "; " + bookGenres.get(i).getBookId());
            assertEquals((i + 1),
                    (bookGenres.get(i).getBookId()));
            assertEquals((i + 1),
                    (bookGenres.get(i).getGenreId()));
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(bookGenresDao.count(), 5);
    }

     */

}