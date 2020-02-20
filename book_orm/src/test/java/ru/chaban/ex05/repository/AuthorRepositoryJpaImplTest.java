package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Author;
import ru.chaban.ex05.domain.Book;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(AuthorRepositoryJpaImpl.class)
class AuthorRepositoryJpaImplTest {

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;

    @Test
    void save() {
        Author author = new Author("XXX");
        author = authorRepositoryJpa.save(author);
        assertEquals(author.getName(), authorRepositoryJpa.findById(author.getId()).get().getName());
    }

    @Test
    void findById() {
        Optional<Author> author = authorRepositoryJpa.findById(1);
        assertEquals("Автор 1", author.get().getName());
    }

    @Test
    void findAll() {
        assertEquals(true, authorRepositoryJpa.findAll().size() > 0);
        int i = 0;
        for (Author author : authorRepositoryJpa.findAll()) {
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
        assertEquals(1, authorRepositoryJpa.findByName("Автор 1").get(0).getId());
    }

    @Test
    void updateNameById() {
        authorRepositoryJpa.updateNameById(2, "222");
        assertEquals("222", authorRepositoryJpa.findById(2).get().getName());
    }

    @Test
    void deleteById() {
        int cnt = authorRepositoryJpa.findAll().size();
        authorRepositoryJpa.deleteById(2);
        assertEquals(cnt, authorRepositoryJpa.findAll().size()+1);
    }
}