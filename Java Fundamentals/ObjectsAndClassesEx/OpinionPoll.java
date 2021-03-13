package ObjectsAndClassesEx;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {

    static class Person {

        String name;
        int age;

        public Person (String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName () {
            return this.name;
        }
        public int getAge() {
            return this.age;
        }

        public String toString() {
            return String.format("%s - %d", getName(), getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputCount = Integer.parseInt(scanner.nextLine());
        List<Person> allPeople = new ArrayList<>();

        while (inputCount > 0) {

            String[] input = scanner.nextLine().split(" ");
            Person currentPerson = new Person(input[0], Integer.parseInt(input[1]));
            allPeople.add(currentPerson);

            inputCount--;
        }

        allPeople.stream()
                .filter(person -> person.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(person -> System.out.println(person.toString()));
    }
}
