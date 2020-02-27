package ru.chaban.ex05.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Author;
import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.repository.AuthorRepositoryJpa;
import ru.chaban.ex05.repository.AuthorRepositoryJpaImpl;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({AuthorServiceImpl.class, AuthorRepositoryJpaImpl.class})
class AuthorServiceImplTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;

    @Test
    void findAll() {

        assertEquals(true, authorService.findAll().size() > 0);
        int i = 0;
        for (Author author : authorService.findAll()) {
            assertEquals("Автор " + ++i, author.getName());

            System.out.println("Автор: " + author.getName());
            int j = 0;
            for (Book book : author.getBooks()) {
                System.out.println("\t" + book.getName());
                assertEquals("Книга " + ++j, book.getName());
            }
        }
    }

    @Test
    void findByName() {
        assertEquals(1, authorService.findByName("Автор 1").get(0).getId());
    }

    @Test
    void updateNameById() {
        authorService.updateNameById(2, "222");
        assertEquals("222", authorRepositoryJpa.findById(2).get().getName());
    }

}