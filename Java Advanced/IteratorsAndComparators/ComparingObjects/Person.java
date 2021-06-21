package IteratorsAndComparators.ComparingObjects;

import javax.swing.*;
import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    private void setAge(){
        if (this.age < 0) {
            throw new IllegalStateException("Invalid age!");
        }
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        int output = this.name.compareTo(p.name);
        if (output == 0) {
            output = Integer.compare(this.age, p.age);
            if (output == 0) {
                output = this.town.compareTo(p.town);
            }
        }
        return output;
    }
}
