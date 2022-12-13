package com.bankingService.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class BasicIdentifier {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
