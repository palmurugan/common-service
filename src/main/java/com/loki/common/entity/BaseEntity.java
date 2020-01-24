package com.loki.common.entity;

import com.loki.common.model.Auditing;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity extends Auditing<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
