package FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int entries = Integer.parseInt(scanner.nextLine());

        Function<String, Person> parsePerson = entry -> {
            String[] personData = entry.split(",\\s+");
            return new Person(personData[0], Integer.parseInt(personData[1]));
        };

        List<Person> peopleDatabase = new ArrayList<>();

        while (entries-- > 0) {
            peopleDatabase.add(parsePerson.apply(scanner.nextLine()));
        }

        String condition = scanner.nextLine();
        int threshold = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        peopleDatabase = condition.equals("older")
                ? filteredPeople(peopleDatabase, p -> p.getAge() >= threshold)
                : filteredPeople(peopleDatabase, p -> p.getAge() <= threshold);

        System.out.println(formatOutput(peopleDatabase, getFormatting(format), System.lineSeparator()));
    }

    public static Function<Person, String> getFormatting (String format) {

        switch (format) {
            case "name":
                return p -> p.getName();
            case "age":
                return p -> String.valueOf(p.getAge());
            case "name age":
                return p -> String.format("%s - %d", p.getName(), p.getAge());
            default:
                throw new IllegalStateException("Unknown format" + format);
        }
    }

    public static String formatOutput (Collection<Person> people, Function<Person, String> formatter, String delimiter) {

        return people.stream()
                .map(p -> formatter.apply(p))
                .collect(Collectors.joining(delimiter));
    }

    public static List<Person> filteredPeople(Collection<Person> people, Predicate<Person> predicate) {

        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
