package ru.chaban.ex05.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.ex05.domain.MyBooks;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Transactional
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
    public List<MyBooks> findAll() {
        TypedQuery<MyBooks> query = em.createQuery("select s from MyBooks s", MyBooks.class);
        return query.getResultList();
    }

    @Override
    public List<MyBooks> findByName(String name) {
        TypedQuery<MyBooks> query = em.createQuery("select s " +
                        "from OtusStudent s " +
                        "where s.name = :name",
                MyBooks.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public void updateNameById(long id, String name) {
        Query query = em.createQuery("update OtusStudent s " +
                "set s.name = :name " +
                "where s.id = :id");
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete " +
                "from OtusStudent s " +
                "where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
