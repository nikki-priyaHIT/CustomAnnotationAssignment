package com.springProject.springAssignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
public class Entities {
    @Id
    private String keyContent;
    private String valueContent;

    public Entities() {}

    public Entities(String msgKey, String msgValue) {
        this.keyContent = msgKey;
        this.valueContent = msgValue;
    }

    public String getKey() { return keyContent; }
    public String getValue() { return valueContent; }
}
