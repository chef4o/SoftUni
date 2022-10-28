package core;

import models.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class ManagementImpl implements Management {

    private Map<String, Employee> employees;
    private Set<Employee> subOrdinates;

    public ManagementImpl() {
        this.employees = new LinkedHashMap<>();
        this.subOrdinates = new HashSet<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        Employee current = this.employees.get(employee.getId());
        if (current != null) {
           return;
        }

        this.employees.put(employee.getId(), employee);
        if (!employee.getSubordinates().isEmpty()) {
            for (Employee subordinate : employee.getSubordinates()) {
                addEmployee(subordinate);
                this.subOrdinates.add(subordinate);
            }
        }
    }

    @Override
    public boolean contains(Employee employee) {
        return this.employees.containsKey(employee.getId());
    }

    @Override
    public int size() {
        return this.employees.size();
    }

    @Override
    public Employee getEmployee(String employeeId) {
        checkIfPresent(employeeId);
        return this.employees.get(employeeId);
    }

    @Override
    public void removeEmployee(String employeeId) {
        checkIfPresent(employeeId);
        this.employees.remove(employeeId);
    }

    @Override
    public Iterable<Employee> getManagerEmployees(String managerId) {
        Employee manager = getEmployee(managerId);

        List<Employee> subordinates = manager.getSubordinates();
        if (subordinates.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return manager.getSubordinates().stream()
                .sorted((a, b) -> b.getMonthsInService() - a.getMonthsInService())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Employee> getCLevelManagement() {
        return this.employees.values().stream()
                .filter(e -> !subOrdinates.contains(e))
                .sorted((a,b) -> {
                    int bySubordinates = b.getSubordinates().size() - a.getSubordinates().size();
                    if (bySubordinates == 0) {
                        return a.getMonthsInService() - b.getMonthsInService();
                    }
                    return bySubordinates;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Employee> getEmployeesInTimeServedRange(Integer lowerBound, Integer upperBound) {
        return this.employees.values().stream()
                .filter(e -> e.getMonthsInService() >= lowerBound
                        && e.getMonthsInService() <= upperBound)
                .sorted((a,b) -> {
                    int byMonthsInService = b.getMonthsInService() - a.getMonthsInService();
                    if (byMonthsInService == 0) {
                        return a.getName().compareTo(b.getName());
                    }
                    return byMonthsInService;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Employee> getAllEmployeesOrderedByCountOfSubordinatesThenByTimeServedThenByName() {
        return this.employees.values().stream()
                .sorted((a,b) -> {
                    int bySubordinateCount = b.getSubordinates().size() - a.getSubordinates().size();
                    if (bySubordinateCount == 0) {
                        int byMonthsOfService = b.getMonthsInService() - a.getMonthsInService();
                        if (byMonthsOfService == 0) {
                            return a.getName().compareTo(b.getName());
                        }
                        return byMonthsOfService;
                    }
                    return bySubordinateCount;
                })
                .collect(Collectors.toList());
    }

    private void checkIfPresent(String employeeId) {
        if (!this.employees.containsKey(employeeId)) {
            throw new IllegalArgumentException();
        }
    }
}
