package ru.chaban.whiteMagic.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class AuthorTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet() {
        Author author = new Author("Автор 123");
        long id = testEntityManager.persistAndGetId(author, Long.class);
        Author authorFromDb = testEntityManager.find(Author.class, id);
        assertEquals(authorFromDb.getName(), author.getName());
    }

    @Test
    void saveAndGetWithBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("TestBook111"));
        books.add(new Book("TestBook222"));

        Author author = new Author("Автор 123", books);
        long id = testEntityManager.persistAndGetId(author, Long.class);
        Author authorFromDb = testEntityManager.find(Author.class, id);
        assertEquals(authorFromDb.getName(), author.getName());

        assertEquals(true, Arrays.equals(books.toArray(), authorFromDb.getBooks().toArray()));
    }

}