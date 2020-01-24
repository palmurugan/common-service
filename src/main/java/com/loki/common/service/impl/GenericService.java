package com.loki.common.service.impl;

import com.loki.common.mapper.GenericMapper;
import com.loki.common.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @param <E>
 * @param <K>
 * @author Palmurugan C
 */
public class GenericService<D, E, K> implements IGenericService<D, K> {

    private PagingAndSortingRepository<E, K> repository;

    private GenericMapper<D, E> mapper;

    public GenericService(PagingAndSortingRepository<E, K> repository, GenericMapper<D, E> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public D saveOrUpdate(D dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void saveOrUpdateAll(List<D> dtoList) {
        repository.saveAll(mapper.toEntityList(dtoList));
    }

    @Override
    public Page<D> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    @Override
    public Stream<D> findAll() {
        return null;
    }

    @Override
    public Optional<D> findByKey(K id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public void remove(K id) {
        repository.deleteById(id);
    }

    @Override
    public void removeAll(List<D> dtos) {
        repository.deleteAll(mapper.toEntityList(dtos));
    }

}
