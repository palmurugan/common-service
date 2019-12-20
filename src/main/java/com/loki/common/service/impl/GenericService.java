package com.loki.common.service.impl;

import com.loki.common.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Palmurugan C
 * @param <E>
 * @param <K>
 */
public class GenericService<E, K> implements IGenericService<E, K> {

    private PagingAndSortingRepository<E, K> repository;

    public GenericService(PagingAndSortingRepository<E, K> repository) {
        this.repository = repository;
    }

    @Override
    public E saveOrUpdate(E entity) {
        return repository.save(entity);
    }

    @Override
    public void saveOrUpdateAll(List<E> entities) {
        repository.saveAll(entities);
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Stream<E> findAll() {
        return null;
    }

    @Override
    public Optional<E> findByKey(K id) {
        return repository.findById(id);
    }

    @Override
    public void remove(K id) {
        repository.deleteById(id);
    }

    @Override
    public void removeAll(List<E> entities) {
        repository.deleteAll(entities);
    }

}
