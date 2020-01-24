package com.loki.common.mapper;

import java.util.List;

/**
 * @author palmurugan
 * @param <E>
 * @param <D>
 */
public interface GenericMapper<D, E> {

    D toDTO(E entity);

    E toEntity(D dto);

    List<D> toDTOList(List<E> entityList);

    List<E> toEntityList(List<D> dtoList);

}
