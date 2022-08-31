package com.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    List<T> getAll();
    T getById(ID id);
    T update(T t);
    T insert(T t);
    void deleteById(ID id);

}
