package com.manazello.administration.business.businesimpl;

import java.util.List;

public interface Iservice <T> {
    T add(T entity);
    List<T> findAllActive();
    List<T> findAllArchived();
    T update(T entity );
    T findById(String id);
    T archived(T entity);

    int countUnderValidation();
    int countPending();
    int countApproved();
    int countDenied();
}
