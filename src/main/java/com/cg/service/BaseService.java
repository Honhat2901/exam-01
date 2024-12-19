package com.cg.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<E, T> {

    List<E> findAll();

    Optional<E> findById(T id);

    E save(E e);

    E updateById(E e, T id);

    void deleteById(T id);
}
