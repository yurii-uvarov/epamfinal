package ua.nure.uvarov.dao;

import java.util.List;

public interface GenericDao<T> {
    T getById(int id);
    int create(T entity);
    void update(T entity);
    void delete(T entity);


}

