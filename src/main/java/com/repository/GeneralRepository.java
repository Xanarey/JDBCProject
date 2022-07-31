package com.repository;

import java.util.List;

public interface GeneralRepository<T, ID> {

    List<T> getAll();
    T getById(ID id);
    T update(T id);
    void deleteById(Long id);
    T insert(T id);

}
