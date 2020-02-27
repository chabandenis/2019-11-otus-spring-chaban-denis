package ru.chaban.ex05.service;

import org.springframework.stereotype.Service;
import ru.chaban.ex05.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Genre> findAll() {
        TypedQuery<Genre> query = em.createQuery("select s from Genre s ", Genre.class);
        return query.getResultList();
    }

    @Override
    public List<Genre> findByName(String name) {
        TypedQuery<Genre> query = em.createQuery("select s " +
                        "from Genre s " +
                        "where s.name = :name",
                Genre.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public void updateNameById(long id, String name) {
        Query query = em.createQuery("update Genre s " +
                "set s.name = :name " +
                "where s.id = :id");
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}