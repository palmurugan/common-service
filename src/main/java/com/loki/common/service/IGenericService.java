package com.loki.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface IGenericService<E, K> {

    E saveOrUpdate(E entity);

    void saveOrUpdateAll(List<E> entities);

    Page<E> findAll(Pageable pageable);

    Stream<E> findAll();

    Optional<E> findByKey(K id);

    void remove(K id);

    void removeAll(List<E> entities);

}
