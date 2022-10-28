package models;

import java.util.List; // 206550
//466550

public class Employee {
    private String id;

    private String name;

    private int monthsInService;

    private List<Employee> subordinates;

    public Employee(String id, String name, int monthsInService, List<Employee> subordinates) {
        this.id = id;
        this.name = name;
        this.monthsInService = monthsInService;
        this.subordinates = subordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthsInService() {
        return monthsInService;
    }

    public void setMonthsInService(int monthsInService) {
        this.monthsInService = monthsInService;
    }

    public List<Employee> getSubordinates() {
            return subordinates;
        }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }
}
