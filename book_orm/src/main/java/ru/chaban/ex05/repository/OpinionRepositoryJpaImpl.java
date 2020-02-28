package ru.chaban.ex05.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.ex05.domain.Opinion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

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
    public void deleteById(Opinion opinion) {
        em.remove(opinion);
        //em.detach(opinion);
    }
}
