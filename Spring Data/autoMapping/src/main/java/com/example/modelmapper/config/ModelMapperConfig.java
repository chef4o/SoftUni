package com.example.modelmapper.config;

import com.example.modelmapper.model.dto.EmployeeDto;
import com.example.modelmapper.model.entity.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper = new ModelMapper();

        TypeMap<Employee, EmployeeDto> typeMap = mapper.createTypeMap(Employee.class, EmployeeDto.class);
        typeMap.addMappings(mapping -> mapping.map(Employee::getSalary, EmployeeDto::setIncome));

//        //Alternative approach
//        mapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
//            @Override
//            protected void configure() {
//                map().setIncome(source.getSalary());
//            }
//        });

        return mapper;
    }
}
