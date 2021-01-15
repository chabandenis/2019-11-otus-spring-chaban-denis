package ru.chaban.whiteMagic.service;

import org.springframework.stereotype.Service;
import ru.chaban.whiteMagic.domain.Opinion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
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
}
