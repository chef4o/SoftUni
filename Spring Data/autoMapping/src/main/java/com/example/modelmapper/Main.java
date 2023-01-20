package com.example.modelmapper;

import com.example.modelmapper.model.dto.EmployeeDto;
import com.example.modelmapper.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;

    public Main(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        EmployeeDto employee = this.employeeService.findOne(1L);
        System.out.println(employee.getFirstName());
    }
}
