package com.objectmapping.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class ManagerDto extends BasicEmployeeDto {

    @Expose
    Set<EmployeeDto> workers;

    public ManagerDto() {
    }

    public Set<EmployeeDto> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<EmployeeDto> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder()
            .append(super.getFirstName()).append(" ")
            .append(super.getLastName()).append(" | ");
        return output.toString();
    }
}
