package IteratorsAndComparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Person> people = new ArrayList<>();

        String input;
        while (!(input = scanner.nextLine()).equals("END")) {

            String[] currentPerson = input.split("\\s+");
            Person person = new Person(currentPerson[0], Integer.parseInt(currentPerson[1]), currentPerson[2]);
            people.add(person);
        }

        int command = Integer.parseInt(scanner.nextLine());
        Person search = people.get(command - 1);

        int matches = 0;
        for (Person person : people) {
            if (person.compareTo(search) == 0) {
                matches++;
            }
        }

        if (matches == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d",
                    matches, people.size() - matches, people.size()));
        }
    }
}
