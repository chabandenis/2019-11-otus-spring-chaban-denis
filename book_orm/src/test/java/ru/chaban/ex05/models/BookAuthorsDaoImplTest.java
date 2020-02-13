package ru.chaban.ex05.models;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

@DisplayName("Проверим связь книги и автора")
@JdbcTest
class BookAuthorsDaoImplTest {
/*
    @Autowired
    private BookAuthorsDao bookAuthorsDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        long uuidBook = 11;
        long uuidAuthor = 22;
        long idBookAutors = bookAuthorsDao.insert(new BookAuthors(uuidBook, uuidAuthor));
        assertEquals(idBookAutors, bookAuthorsDao.getById(idBookAutors).getId());
        assertEquals(uuidBook, bookAuthorsDao.getById(idBookAutors).getBookId());
        assertEquals(uuidAuthor, bookAuthorsDao.getById(idBookAutors).getAuthorId());
    }

    @Test
    void constructor() {
        long uuidBook = 11;
        long uuidAuthor = 22;

        BookAuthors bookAuthors = new BookAuthors(uuidBook, uuidAuthor);

        assertEquals(uuidBook, bookAuthors.getBookId());
        assertEquals(uuidAuthor, bookAuthors.getAuthorId());
    }


    @DisplayName("изменение")
    @Test
    void update() {
        long uuidBook = 11;
        long uuidAuthor = 22;

        long uuidBookNew = 33;
        long uuidAuthorNew = 44;


        long idBookAutors = bookAuthorsDao.insert(new BookAuthors(uuidBook, uuidAuthor));
        assertEquals(uuidBook, bookAuthorsDao.getById(idBookAutors).getBookId());
        assertEquals(uuidAuthor, bookAuthorsDao.getById(idBookAutors).getAuthorId());

        BookAuthors bookAuthors = new BookAuthors(uuidBookNew, uuidAuthorNew);
        bookAuthors.setId(idBookAutors);

        assertEquals(uuidBookNew, bookAuthors.getBookId());
        assertEquals(uuidAuthorNew, bookAuthors.getAuthorId());

        bookAuthorsDao.update(bookAuthors);

        assertEquals(uuidBookNew, bookAuthorsDao.getById(idBookAutors).getBookId());
        assertEquals(uuidAuthorNew, bookAuthorsDao.getById(idBookAutors).getAuthorId());

    }

    @DisplayName("удаление")
    @Test
    void deleteById() {
        assertEquals(bookAuthorsDao.count(), 5);
        bookAuthorsDao.deleteById(5);
        assertEquals(bookAuthorsDao.count(), 4);
    }

    @DisplayName("по ID")
    @Test
    void getById() {
        BookAuthors bookAuthors = bookAuthorsDao.getById(3);
        assertEquals(bookAuthors.getBookId(), 3);
        assertEquals(bookAuthors.getAuthorId(), 3);
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<BookAuthors> bookAuthors = bookAuthorsDao.getAll();
        for (int i = 0; i < 5; i++) {
            System.out.println(bookAuthors.get(i).getId() + "; " + bookAuthors.get(i).getBookId());

            assertEquals((i + 1),
                    bookAuthors.get(i).getBookId());
            assertEquals((i + 1),
                    (bookAuthors.get(i).getAuthorId()));
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(bookAuthorsDao.count(), 5);
    }

 */

}