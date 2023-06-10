package ru.itmo.database.jpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class AbstractDao<T, PK> implements DAO<T, PK>{
    protected final EntityManager entityManager;
    protected final Class<T> clazz;

    public AbstractDao(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    @Override
    public void create(T t) {
        entityManager.persist(t);
    }

    @Override
    public void delete(PK pk) {
        T t = selectByPK(pk);
        entityManager.remove(t);
    }

    @Override
    public void update(T t) {
        entityManager.merge(t);
    }

    @Override
    public List<T> selectAll() {
        List<T> tList = null;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // тип данных результата
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);

        // откуда извлекаются данные
        Root<T> root = criteriaQuery.from(clazz); // FROM таблица

        criteriaQuery.select(root); // SELECT

        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        tList = query.getResultList();

        return tList;
    }

    @Override
    public T selectByPK(PK pk) {
        return entityManager.find(clazz, pk);
    }
}
