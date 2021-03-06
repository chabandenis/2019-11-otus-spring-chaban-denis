package ru.chaban.ex05.service;

import org.springframework.stereotype.Service;
import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.MyBooks;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
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

}
