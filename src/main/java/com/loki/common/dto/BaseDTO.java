package com.loki.common.dto;

import static com.loki.common.utils.CommonConstants.ACTIVE;

public class BaseDTO {

    private Long id;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status != null ? status : ACTIVE;
    }
}
