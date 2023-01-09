package com.objectmapping.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class EmployeeDto extends BasicEmployeeDto {

    private BigDecimal income;

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }
}
