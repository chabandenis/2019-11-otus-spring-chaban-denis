package ru.chaban.ex05.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.ex05.domain.Genre;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class GenreRepositoryJpaImpl implements GenreRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre save(Genre genre) {
        if (genre.getId() <= 0) {
            em.persist(genre);
            return genre;
        } else {
            return em.merge(genre);
        }
    }

    @Override
    public Optional<Genre> findById(long id) {
        return Optional.ofNullable(em.find(Genre.class, id));
    }

    @Override
    public List<Genre> findAll() {
        EntityGraph<?> entityGraph = em.getEntityGraph("ru-chaban-genre-entity-graph");
        TypedQuery<Genre> query = em.createQuery("select s from OtusStudent s join fetch s.emails", Genre.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);
        return query.getResultList();
    }

    @Override
    public List<Genre> findByName(String name) {
        TypedQuery<Genre> query = em.createQuery("select s " +
                        "from OtusStudent s " +
                        "where s.name = :name",
                Genre.class);
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