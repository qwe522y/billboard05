package com.sotas.billboard05.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CrudRepositoryImpl<E, PK> implements CrudRepository<E, PK> {
    @PersistenceContext
    private EntityManager em;
    private Class<E> entityClass;

    public CrudRepositoryImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public E add(E e) {
        em.persist(e);
        return e;
    }

    @Override
    public E get(PK pk) {
        return em.find(entityClass, pk);
    }

    @Override
    public E update(E e) {
        return em.merge(e);
    }

    @Override
    public E remove(PK pk) {
        E e = get(pk);
        em.remove(e);
        return e;
    }

    @Override
    public List<E> getAll() {
        return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
