package ru.chaban.ex05.models;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;


@DisplayName("мои книги")
@JdbcTest
class MyBooksDaoImplTest {
/*
    @Autowired
    private MyBooksDao myBooksDao;

    @DisplayName("вставка")
    @Test
    void insert() {
        long id = myBooksDao.insert(new MyBooks(11));
        assertEquals(id, myBooksDao.getById(id).getId());
        assertEquals(11, myBooksDao.getById(id).getMyBookId());
    }

    @DisplayName("изменение")
    @Test
    void update() {
        long uuidBook = 1;
        long uuidBookNew = 2;
        long idMyBooks = myBooksDao.insert(new MyBooks(uuidBook));

        myBooksDao.update(new MyBooks(idMyBooks, uuidBookNew));

        assertEquals(uuidBookNew, myBooksDao.getById(idMyBooks).getMyBookId());
    }

    @DisplayName("удаление")
    @Test
    void deleteById() {
        assertEquals(myBooksDao.count(), 3);
        myBooksDao.deleteById(2);
        assertEquals(myBooksDao.count(), 2);
    }

    @DisplayName("по ID")
    @Test
    void getById() {
        MyBooks genre = myBooksDao.getById(3);
        assertEquals(genre.getId(), 3);
        assertEquals(genre.getMyBookId(), 3);
    }

    @DisplayName("Все ли загружены")
    @Test
    void getAll() {
        List<MyBooks> genres = myBooksDao.getAll();
        for (int i = 0; i < 3; i++) {
            System.out.println(genres.get(i).getId() + "; " + genres.get(i).getMyBookId());
            assertEquals((i + 1), genres.get(i).getMyBookId());
        }
    }

    @DisplayName("Сколько всего")
    @Test
    void count() {
        assertEquals(myBooksDao.count(), 3);
    }


 */
}