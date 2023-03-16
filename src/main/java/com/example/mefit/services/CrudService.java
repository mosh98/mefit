package com.example.mefit.services;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface CrudService <T, ID> {
    T findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(T entity);
    void deleteById(ID id);
    boolean exists(ID id);
}
