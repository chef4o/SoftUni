package core;

import models.Employee;

import java.util.List;
import java.util.Set;

public interface Management {
    void addEmployee(Employee employee);

    boolean contains(Employee employee);

    int size();

    Employee getEmployee(String employeeId);

    void removeEmployee(String employeeId);

    Iterable<Employee> getManagerEmployees(String managerId);

    Iterable<Employee> getCLevelManagement();

    Iterable<Employee> getEmployeesInTimeServedRange(Integer lowerBound, Integer upperBound);

    Iterable<Employee> getAllEmployeesOrderedByCountOfSubordinatesThenByTimeServedThenByName();
}
