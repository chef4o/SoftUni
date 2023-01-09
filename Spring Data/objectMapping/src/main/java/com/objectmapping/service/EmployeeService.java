package com.objectmapping.service;

import com.objectmapping.model.dto.EmployeeDto;
import com.objectmapping.model.dto.EmployeeInputDto;
import com.objectmapping.model.dto.EmployeeOutputDto;
import com.objectmapping.model.dto.ManagerDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto findOneEmployee(Long id);
    ManagerDto findOneManager(Long id);
    List<ManagerDto> findAll();
    EmployeeOutputDto save(EmployeeInputDto employeeInputDto);
}
