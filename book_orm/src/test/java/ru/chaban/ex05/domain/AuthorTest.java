package ru.chaban.ex05.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class AuthorTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void saveAndGet(){
        Author author = new Author("Автор 123");
        long id=testEntityManager.persistAndGetId(author, Long.class);
        Author authorFromDb = testEntityManager.find(Author.class, id);
        assertEquals(authorFromDb.getName(), author.getName());
    }

}