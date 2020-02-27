package ru.chaban.ex05.service;

import org.springframework.stereotype.Service;
import ru.chaban.ex05.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> query = em.createQuery("select s from Author s", Author.class);
        return query.getResultList();
    }

    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query = em.createQuery("select s " +
                        "from Author s " +
                        "where s.name = :name",
                Author.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

}
