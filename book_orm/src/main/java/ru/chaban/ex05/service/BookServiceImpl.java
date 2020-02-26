package ru.chaban.ex05.service;

import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class BookServiceImpl implements BookService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = em.createQuery("select s from Book s ", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> findByName(String name) {
        TypedQuery<Book> query = em.createQuery("select s " +
                        "from Book s " +
                        "where s.name = :name",
                Book.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public void updateNameById(long id, String name) {
        Query query = em.createQuery("update Book s " +
                "set s.name = :name " +
                "where s.id = :id");
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
