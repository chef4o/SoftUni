package com.example.modelmapper.model.dto;

import com.example.modelmapper.model.entity.Employee;

import java.util.Set;

public class ManagerDto extends BasicEmployeeDto {
    private Set<Employee> workers;

    public Set<Employee> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Employee> workers) {
        this.workers = workers;
    }
}
