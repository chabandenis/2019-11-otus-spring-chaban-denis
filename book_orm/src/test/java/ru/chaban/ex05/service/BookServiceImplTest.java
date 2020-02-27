package ru.chaban.ex05.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Author;
import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.Genre;
import ru.chaban.ex05.domain.Opinion;
import ru.chaban.ex05.repository.BookRepositoryJpa;
import ru.chaban.ex05.repository.BookRepositoryJpaImpl;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({BookRepositoryJpaImpl.class, BookServiceImpl.class})
class BookServiceImplTest {

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

    @Autowired
    private BookService bookService;

    @Test
    void findAll() {
        assertEquals(true, bookService.findAll().size() > 0);
        int i = 0;
        for (Book book : bookService.findAll()) {
            assertEquals("Книга " + ++i, book.getName());

            System.out.println("Книга: " + book.getName());
            int j = 0;
            for (Author author : book.getAuthors()) {
                System.out.println("\t" + author.getName());
                assertEquals("Автор " + ++j, author.getName());
            }
            System.out.println("Книга: " + book.getName());

            j = 0;
            for (Opinion opinion : book.getComments()) {
                System.out.println("\t" + opinion.getComment());
                assertEquals("Рецензия " + ++j, opinion.getComment());
            }

            j = 0;
            for (Genre genre : book.getGenres()) {
                System.out.println("\t" + genre.getName());
                assertEquals("Жанр " + ++j, genre.getName());
            }
        }
    }

    @Test
    void findByName() {
        assertEquals(1, bookService.findByName("Книга 1").get(0).getId());
    }

    @Test
    void updateNameById() {
        bookService.updateNameById(2, "222");
        assertEquals("222", bookRepositoryJpa.findById(2).get().getName());
    }

}