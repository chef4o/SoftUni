package DefiningClassesEx.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Department {

    private String departmentName;
    private List<Employee> employeeList;

    public Department() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
        this.departmentName = employee.getDepartment();
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public double getAverageSalary() {

        OptionalDouble averageSalary = this.employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average();

        return averageSalary.isPresent() ? averageSalary.getAsDouble() : 0d;
    }
}
