package com.loki.common.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Palmurugan
 */
public class ErrorResponse implements Serializable {

    private String code;

    private Date timestamp;

    private String message;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = new Date();
    }

    public ErrorResponse(String message) {
        this.message = message;
        this.timestamp = new Date();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
