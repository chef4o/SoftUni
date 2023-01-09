package com.objectmapping.service;

import com.objectmapping.model.dto.EmployeeDto;
import com.objectmapping.model.dto.EmployeeInputDto;
import com.objectmapping.model.dto.EmployeeOutputDto;
import com.objectmapping.model.dto.ManagerDto;
import com.objectmapping.model.entity.Employee;
import com.objectmapping.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto findOneEmployee(Long id) {
        return this.modelMapper.map(
                this.employeeRepository.findById(id).orElseThrow(),
                EmployeeDto.class);
    }

    @Override
    public ManagerDto findOneManager(Long id) {
        return this.modelMapper.map(
                this.employeeRepository.findById(id).orElseThrow(),
                ManagerDto.class);
    }

    @Override
    public List<ManagerDto> findAll() {
        return this.modelMapper
                .map(this.employeeRepository.findAll(),
                     new TypeToken<List<ManagerDto>>() {}.getType());
    }

    @Override
    public EmployeeOutputDto save(EmployeeInputDto employeeInputDto) {
        Employee employee = this.modelMapper
                .map(employeeInputDto, Employee.class);
        employee = this.employeeRepository.save(employee);
        EmployeeOutputDto employeeOutput = this.modelMapper
                .map(employee, EmployeeOutputDto.class);
        return employeeOutput;
    }

}
