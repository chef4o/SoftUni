package com.objectmapping.configuration;

import com.objectmapping.model.dto.EmployeeDto;
import com.objectmapping.model.dto.EmployeeInputDto;
import com.objectmapping.model.dto.EmployeeOutputDto;
import com.objectmapping.model.entity.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapperEmployee() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<Employee, EmployeeDto> typeMap = mapper
                .typeMap(Employee.class, EmployeeDto.class);
        typeMap
                .addMappings(mapping -> mapping.map(Employee::getSalary, EmployeeDto::setIncome));

        TypeMap<EmployeeInputDto, Employee> typeMapFromJson = mapper
                .typeMap(EmployeeInputDto.class, Employee.class);
        typeMapFromJson.addMappings(m -> m.map(EmployeeInputDto::getIncome, Employee::setSalary));

        TypeMap<Employee, EmployeeOutputDto> typeMapToJson = mapper
                .typeMap(Employee.class, EmployeeOutputDto.class);
        typeMapToJson.addMappings(m -> m.map(Employee::getSalary, EmployeeOutputDto::setIncome));

        return mapper;
    }
}
