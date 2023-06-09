package ru.itmo.database.jpa.dao;

import java.util.List;

public interface DAO<T, PK> {
    void create(T t);
    void delete(PK pk);
    void update(T t);
    List<T> selectAll();
    T selectByPK(PK pk);
}
