package DefiningClassesEx.CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departmentDatabase = new HashMap<>();

        int entries = Integer.parseInt(scanner.nextLine());

        while (entries-- > 0) {
            String[] currentEntry = scanner.nextLine().split("\\s+");
            String name = currentEntry[0];
            double salary = Double.parseDouble(currentEntry[1]);
            String position = currentEntry[2];
            String department = currentEntry[3];

            Employee currentEmployee = null;

            if (currentEntry.length == 4) {
                currentEmployee = new Employee(name, salary, position, department);
            } else if (currentEntry.length == 6) {
                String email = currentEntry[4];
                int age = Integer.parseInt(currentEntry[5]);
                currentEmployee = new Employee(name, salary, position, department, email, age);
            } else if (currentEntry.length == 5) {
                if (currentEntry[4].matches("^\\d+$")) {
                    int age = Integer.parseInt(currentEntry[4]);
                    currentEmployee = new Employee(name, salary, position, department, age);
                } else if (currentEntry[4].matches("^\\w+.?\\w+@\\w+.[A-Za-z]+$")) {
                    String email = currentEntry[4];
                    currentEmployee = new Employee(name, salary, position, department, email);
                } else {
                    currentEmployee = new Employee(name, salary, position, department);
                }
            }

            if (!departmentDatabase.containsKey(department)) {
                departmentDatabase.put(department, new Department());
            }

            departmentDatabase.get(department).addEmployee(currentEmployee);
        }

        double maxValue = 0;
        String bestDepartment = "";
        for (Department department : departmentDatabase.values()) {
            if (department.getAverageSalary() > maxValue) {
                maxValue = department.getAverageSalary();
                bestDepartment = department.getDepartmentName();
            }
        }

        System.out.printf("Highest Average Salary: %s%s", bestDepartment, System.lineSeparator());

        List<Employee> sortedBySalary = departmentDatabase.get(bestDepartment)
                .getEmployeeList()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                .reversed())
                .collect(Collectors.toList());

        sortedBySalary.forEach(employee -> System.out.println(employee.toString()));
    }
}
