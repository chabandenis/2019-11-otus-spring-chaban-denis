package ru.chaban.ex05.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.ex05.domain.Opinion;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class OpinionRepositoryJpaImpl implements OpinionRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Opinion save(Opinion opinion) {
        if (opinion.getId() <= 0) {
            em.persist(opinion);
            return opinion;
        } else {
            return em.merge(opinion);
        }
    }

    @Override
    public Optional<Opinion> findById(long id) {
        return Optional.ofNullable(em.find(Opinion.class, id));
    }

    @Override
    public List<Opinion> findAll() {
        TypedQuery<Opinion> query = em.createQuery("select s from Opinion s", Opinion.class);
        return query.getResultList();
    }

    @Override
    public List<Opinion> findByName(String name) {
        TypedQuery<Opinion> query = em.createQuery("select s " +
                        "from OtusStudent s " +
                        "where s.name = :name",
                Opinion.class);
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
