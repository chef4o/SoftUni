package ObjectsAndClassesEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    static class Person {
        String name;
        String id;
        int age;

        public Person (String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName () {
            return this.name;
        }
        public String getId() {
            return this.id;
        }
        public int getAge() {
            return this.age;
        }

        public String toString() {
            return String.format("%s with ID: %s is %d years old.",
                    getName(), getId(), getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Person> allPeople = new ArrayList<>();

        while (!input[0].equals("End")) {

            String name = input[0];
            String id = input[1];
            int age = Integer.parseInt(input[2]);

            Person newPerson = new Person(name, id, age);
            allPeople.add(newPerson);

            input = scanner.nextLine().split(" ");
        }

        allPeople.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .forEach(person -> System.out.println(person.toString()));
    }
}
