package com.example.modelmapper.service;

import com.example.modelmapper.model.dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeDto findOne(Long id);
    EmployeeDto findAll();
}
