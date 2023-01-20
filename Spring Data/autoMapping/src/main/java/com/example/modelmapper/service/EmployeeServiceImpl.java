package com.example.modelmapper.service;

import com.example.modelmapper.model.dto.EmployeeDto;
import com.example.modelmapper.model.dto.ManagerDto;
import com.example.modelmapper.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDto findOne(Long id) {
        return mapper.map(this.employeeRepository.findById(id).orElseThrow(),
                EmployeeDto.class);
    }

    @Override
    public EmployeeDto findAll() {
        return mapper.map(this.employeeRepository.findAll(),
                new TypeToken<List<ManagerDto>>() { }.getType()
        );
    }
}
