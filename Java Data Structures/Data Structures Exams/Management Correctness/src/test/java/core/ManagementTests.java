import core.Management;
import core.ManagementImpl;

import models.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class ManagementTests {
    private interface InternalTest {
        void execute();
    }

    private Management management;

    private Employee getRandomEmployeeWithoutSubordinates() {
        return new Employee(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                (int) Math.min(1, Math.random() * 1_000_000_000),
                new ArrayList<>());
    }

    @Before
    public void setup() {
        this.management = new ManagementImpl();
    }

    // Correctness Tests

    @Test
    public void testaddEmployee_ShouldSuccessfullyaddEmployee() {
        this.management.addEmployee(this.getRandomEmployeeWithoutSubordinates());
        this.management.addEmployee(this.getRandomEmployeeWithoutSubordinates());

        assertEquals(2, this.management.size());
    }

    @Test
    public void testContains_WithExistentEmployee_ShouldReturnTrue() {
        Employee randomEmployee = this.getRandomEmployeeWithoutSubordinates();

        this.management.addEmployee(randomEmployee);

        assertTrue(this.management.contains(randomEmployee));
    }

    @Test
    public void testContains_WithNonexistentEmployee_ShouldReturnFalse() {
        Employee randomEmployee = this.getRandomEmployeeWithoutSubordinates();

        this.management.addEmployee(randomEmployee);

        assertFalse(this.management.contains(this.getRandomEmployeeWithoutSubordinates()));
    }

    @Test
    public void testCount_With5Employees_ShouldReturn5() {
        this.management.addEmployee(this.getRandomEmployeeWithoutSubordinates());
        this.management.addEmployee(this.getRandomEmployeeWithoutSubordinates());
        this.management.addEmployee(this.getRandomEmployeeWithoutSubordinates());
        this.management.addEmployee(this.getRandomEmployeeWithoutSubordinates());
        this.management.addEmployee(this.getRandomEmployeeWithoutSubordinates());

        assertEquals(5, this.management.size());
    }

    @Test
    public void testGetManagerEmployees_ShouldReturnCorrectEmployees() {
        Employee mainEmployee = this.getRandomEmployeeWithoutSubordinates();

        Employee childEmployee = this.getRandomEmployeeWithoutSubordinates();
        Employee child2Employee = this.getRandomEmployeeWithoutSubordinates();
        Employee child3Employee = this.getRandomEmployeeWithoutSubordinates();

        Employee subChildEmployee = new Employee(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 100, new ArrayList<>());
        Employee subChild2Employee = this.getRandomEmployeeWithoutSubordinates();
        Employee subChild3Employee = new Employee(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 200, new ArrayList<>());

        childEmployee.getSubordinates().add(subChildEmployee);
        childEmployee.getSubordinates().add(subChild3Employee);
        child2Employee.getSubordinates().add(subChild2Employee);

        mainEmployee.getSubordinates().add(childEmployee);
        mainEmployee.getSubordinates().add(child2Employee);
        mainEmployee.getSubordinates().add(child3Employee);

        this.management.addEmployee(mainEmployee);

        List<Employee> channel = StreamSupport.stream(this.management.getManagerEmployees(childEmployee.getId()).spliterator(), false)
                .collect(Collectors.toList());
        ;

        assertEquals(2, channel.size());
        assertEquals(subChild3Employee, channel.get(0));
        assertEquals(subChildEmployee, channel.get(1));
    }

    @Test
    public void testRemoveEmployee_WithCorrectData_ShouldDecrementCount() {
        Employee Employee = new Employee("asd", "Pesho", 10, new ArrayList<>());
        Employee Employee2 = new Employee(UUID.randomUUID().toString(), "Tosho", 25, new ArrayList<>());
        Employee Employee3 = new Employee(UUID.randomUUID().toString(), "Sasho", 30, new ArrayList<>());
        Employee Employee4 = new Employee(UUID.randomUUID().toString(), "Gosho", 25, new ArrayList<>());
        Employee Employee5 = new Employee(UUID.randomUUID().toString(), "Isho", 20, new ArrayList<>());

        this.management.addEmployee(Employee);
        this.management.addEmployee(Employee2);
        this.management.addEmployee(Employee3);
        this.management.addEmployee(Employee4);
        this.management.addEmployee(Employee5);

        this.management.removeEmployee("asd");

        assertEquals(4, this.management.size());
    }

    // Performance Tests

    @Test
    public void testAddEmployee_With100000Results_ShouldPassQuickly() {
        int count = 100000;

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            this.management.addEmployee(new Employee(i + "", "Title" + i, i * 100, new ArrayList<>()));
        }

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime < 450);
    }
}
