package ru.chaban.ex05.service;

import org.springframework.stereotype.Repository;
import ru.chaban.ex05.domain.Opinion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class OpinionServiceImpl implements OpinionService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Opinion> findAll() {
        TypedQuery<Opinion> query = em.createQuery("select s from Opinion s", Opinion.class);
        return query.getResultList();
    }

    @Override
    public List<Opinion> findByName(String name) {
        TypedQuery<Opinion> query = em.createQuery("select s " +
                        "from Opinion s " +
                        "where s.comment = :name",
                Opinion.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public void updateNameById(long id, String name) {
        Query query = em.createQuery("update Opinion s " +
                "set s.comment = :name " +
                "where s.id = :id");
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
