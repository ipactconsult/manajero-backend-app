package com.manazello.projectmanagement.business.ibusiness;

import java.util.List;

public interface IService<T> {
     T add(T entity);
     List<T> findAllActive();
     List<T> findAllArchived();
     boolean delete (String id);
     T update(T enity );
     T findById(String id);

}
