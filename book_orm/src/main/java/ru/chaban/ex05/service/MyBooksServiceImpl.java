package ru.chaban.ex05.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.MyBooks;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class MyBooksServiceImpl implements MyBooksService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MyBooks> findAll() {
        TypedQuery<MyBooks> query = em.createQuery("select s from MyBooks s", MyBooks.class);
        return query.getResultList();
    }

    @Override
    public List<MyBooks> findByName(String name) {
        TypedQuery<MyBooks> query = em.createQuery("select s " +
                        "from MyBooks s, Book b " +
                        "where s.book = b.id and b.name = :name",
                MyBooks.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateNameById(long id, Book book) {
        Query query = em.createQuery("update MyBooks s " +
                "set s.book = :book " +
                "where s.id = :id");
        query.setParameter("book", book);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}