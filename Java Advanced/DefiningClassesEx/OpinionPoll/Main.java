package DefiningClassesEx.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args0) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        List<Person> peopleDatabase = new ArrayList<>();

        while (people-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            peopleDatabase.add(new Person(name, age));
        }

        List<String> output = formattedOutput(peopleDatabase);


        printing(output);
    }

    public static void printing (List<String> output) {
        System.out.println(output.stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    public static List<String> formattedOutput(List<Person> inputDatabase) {
        return inputDatabase.stream()
                .filter(p -> p.getAge() > 30)
                .map(p -> String.format("%s - %d", p.getName(), p.getAge()))
                .sorted()
                .collect(Collectors.toList());
    }
}
