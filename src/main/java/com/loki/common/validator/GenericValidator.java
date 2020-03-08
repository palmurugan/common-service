package com.loki.common.validator;

/**
 * @author palmurugan
 * @param <D>
 */
public interface GenericValidator<D> {

    public void validate(D dto);
}
