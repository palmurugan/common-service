package com.loki.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface IGenericService<D, K> {

    D saveOrUpdate(D entity);

    void saveOrUpdateAll(List<D> entities);

    Page<D> findAll(Pageable pageable);

    Stream<D> findAll();

    Optional<D> findByKey(K id);

    void remove(K id);

    void removeAll(List<D> entities);

}
