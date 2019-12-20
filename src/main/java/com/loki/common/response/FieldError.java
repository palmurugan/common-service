package com.loki.common.response;

import java.util.Date;
import java.util.List;

/**
 * @author palmurugan
 */
public class FieldError {

    private String message;

    private Date timestamp;

    private List<String> errors;

    public FieldError(String message, Date timestamp, List<String> errors) {
        this.message = message;
        this.timestamp = timestamp;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
