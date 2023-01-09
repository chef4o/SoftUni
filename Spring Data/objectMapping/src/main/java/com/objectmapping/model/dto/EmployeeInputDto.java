package com.objectmapping.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class EmployeeInputDto extends BasicEmployeeDto{

    @Expose
    private String address;

    @Expose
    private BigDecimal income;

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
