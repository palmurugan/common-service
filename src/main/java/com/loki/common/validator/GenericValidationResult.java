package com.loki.common.validator;

import java.util.Optional;

/**
 * @author palmurugan
 */
public class GenericValidationResult {

    private boolean valid;

    public GenericValidationResult(boolean valid) {
        this.valid = valid;
    }

    public static GenericValidationResult ok() {
        return new GenericValidationResult(Boolean.TRUE);
    }

    public static GenericValidationResult fail() {
        return new GenericValidationResult(Boolean.FALSE);
    }

    public Optional<String> getFieldErrorIfInValid(String message) {
        return this.valid ? Optional.empty() : Optional.of(message);
    }

    public boolean isValid() {
        return valid;
    }
}
