package encapsulation.salaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (getAge() >= 30) {
            setSalary(getSalary() * (1 + bonus / 100d));
        } else {
            setSalary(getSalary() * (1 + (bonus / 2) / 100d));
        }
    }

    @Override
    public String toString() {
        DecimalFormat formattedSalary = new DecimalFormat("#.0##");
        return String.format("%s %s gets %s leva",
                getFirstName(), getLastName(), formattedSalary.format(getSalary()));
    }
}
