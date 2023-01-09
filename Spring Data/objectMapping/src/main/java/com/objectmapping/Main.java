package com.objectmapping;

import com.google.gson.Gson;
import com.objectmapping.model.dto.EmployeeInputDto;
import com.objectmapping.model.dto.EmployeeOutputDto;
import com.objectmapping.model.dto.ManagerDto;
import com.objectmapping.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.List;


@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final Gson gson;
    private final BufferedReader reader;

    public Main(EmployeeService employeeService, Gson gson, BufferedReader bufferedReader) {
        this.employeeService = employeeService;
        this.gson = gson;
        this.reader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Input a command");
        String line;
        while (!(line = reader.readLine()).toLowerCase().equals("end")) {
            String[] commands = line.split("\\s+", 2);
            switch (commands[0]) {
                case "find" -> {
                    Long id = Long.valueOf(commands[1]);
                    ManagerDto manager = this.employeeService.findOneManager(id);
                    String result = this.gson.toJson(manager);
                    System.out.println(result);
                }
                case "findAll" -> {
                    List<ManagerDto> managers = this.employeeService.findAll();
                    System.out.println(this.gson.toJson(managers));
                }
                case "save" -> {
                    String json = commands[1];
                    EmployeeInputDto input = this.gson
                                            .fromJson(json, EmployeeInputDto.class);
                    EmployeeOutputDto output = this.employeeService.save(input);
                    System.out.println(this.gson.toJson(output));
                }
            }
        }
    }
}
