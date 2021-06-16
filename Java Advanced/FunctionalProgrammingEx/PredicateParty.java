package FunctionalProgrammingEx;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    static List<String> names = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        names = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!(input = scanner.nextLine()).equals("Party!")) {

            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Double":
                    addOne(getPredicate(commands));
                    break;
                case "Remove":
                    removeOne(getPredicate(commands));
                    break;
            }
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            System.out.printf("%s are going to the party!",
                    names.toString().replaceAll("[\\[\\]]",""));
        }
    }

    private static void removeOne(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    public static void addOne(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(e -> namesToAdd.add(e));
        names.addAll(namesToAdd);
    }

    public static Predicate<String> getPredicate (String[] command) {

        Predicate<String> predicate;
        if (command[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(command[2]);
        } else if (command[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(command[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(command[2]);
        }

        return predicate;
    }
}
