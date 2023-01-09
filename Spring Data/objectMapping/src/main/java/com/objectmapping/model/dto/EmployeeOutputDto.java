package com.objectmapping.model.dto;

import com.google.gson.annotations.Expose;

public class EmployeeOutputDto extends EmployeeInputDto{

    @Expose
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
