package com.manazello.pm.business.ibusiness;

import java.util.List;

public interface InterfaceService<T> {

    T add(T entity);

    List<T> findAll();

    boolean delete(String id);

    T update(T entity);

    T findById(String id);
}
