package com.supermap.dao;

import java.io.Serializable;
import java.util.List;

public interface DomainRepository<T,PK extends Serializable> {
    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    boolean delete(PK id);

    void flush();
}
