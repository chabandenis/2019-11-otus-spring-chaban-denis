package ru.chaban.ex05.repository;

import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.MyBooks;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MyBooksRepositoryJpaImpl implements MyBooksRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MyBooks save(MyBooks myBooks) {
        if (myBooks.getId() <= 0) {
            em.persist(myBooks);
            return myBooks;
        } else {
            return em.merge(myBooks);
        }
    }

    @Override
    public Optional<MyBooks> findById(long id) {
        return Optional.ofNullable(em.find(MyBooks.class, id));
    }

    @Override
    public void deleteById(MyBooks myBooks) {
        em.remove(myBooks);
    }
}
