package ru.chaban.ex05.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chaban.ex05.domain.Author;

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
    void deleteById() {
        /*int cnt = authorRepositoryJpa.findAll().size();
        authorRepositoryJpa.deleteById(2);
        assertEquals(cnt, authorRepositoryJpa.findAll().size() + 1);*/
    }
}