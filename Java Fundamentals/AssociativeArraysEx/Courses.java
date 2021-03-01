package AssociativeArraysEx;

import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" : ");

        Map<String, List<String>> databaseNames = new LinkedHashMap<>();
        Map<String, Integer> databaseCounts = new LinkedHashMap<>();

        while (!input[0].equals("end")) {

            String course = input[0];
            String name = input[1];

            if (!databaseNames.containsKey(course)) {
                databaseNames.put(course, new ArrayList<>());
                databaseCounts.put(course, 0);
            }

            databaseNames.get(course).add(name);
            databaseNames.put(course, databaseNames.get(course)
                                                    .stream()
                                                    .sorted()
                                                    .collect(Collectors.toList())) ;

            databaseCounts.put(course, databaseCounts.get(course) + 1);

            input = scanner.nextLine().split(" : ");
        }

        databaseCounts.entrySet()
                .stream()
                .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                .forEach(e -> System.out.printf("%s: %d\n-- %s\n",
                                                e.getKey(),
                                                e.getValue(),
                                                String.join("\n-- ", databaseNames.get(e.getKey()))
                ));
    }
}
