package ru.chaban.whiteMagic.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.whiteMagic.domain.Author;
import ru.chaban.whiteMagic.domain.Book;
import ru.chaban.whiteMagic.domain.Genre;
import ru.chaban.whiteMagic.domain.Opinion;
import ru.chaban.whiteMagic.repository.BookRepositoryJpa;
import ru.chaban.whiteMagic.repository.BookRepositoryJpaImpl;

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

}