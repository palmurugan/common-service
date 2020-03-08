package com.loki.common.validator;

import java.util.function.Predicate;

/**
 * @param <K>
 * @author palmurugan
 */
public class GenericValidation<K> implements Validation<K> {

    private Predicate<K> predicate;

    public GenericValidation(Predicate<K> predicate) {
        this.predicate = predicate;
    }

    public static <K> GenericValidation<K> from(Predicate<K> predicate) {
        return new GenericValidation<>(predicate);
    }

    @Override
    public GenericValidationResult test(K param) {
        return predicate.test(param) ? GenericValidationResult.ok() : GenericValidationResult.fail();
    }
}
