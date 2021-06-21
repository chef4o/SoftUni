package IteratorsAndComparators.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> sortedByAgeSet = new TreeSet<>(new AgeComparator());
        Set<Person> sortedByNameSet = new TreeSet<>(new NameComparator());

        int inputs = Integer.parseInt(scanner.nextLine());

        while (inputs-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Person currentPerson = new Person(input[0], Integer.parseInt(input[1]));
            sortedByAgeSet.add(currentPerson);
            sortedByNameSet.add(currentPerson);
        }

        sortedByNameSet.forEach(p -> System.out.println(p.toString()));
        sortedByAgeSet.forEach(p -> System.out.println(p.toString()));
    }
}