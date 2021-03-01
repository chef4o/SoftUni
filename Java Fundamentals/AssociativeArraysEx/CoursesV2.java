package AssociativeArraysEx;

import java.util.*;
import java.util.stream.Collectors;

public class CoursesV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" : ");

        Map<String, List<String>> databaseNames = new LinkedHashMap<>();

        while (!input[0].equals("end")) {

            String course = input[0];
            String name = input[1];

            if (!databaseNames.containsKey(course)) {
                databaseNames.put(course, new ArrayList<>());
            }

            databaseNames.get(course).add(name);

            input = scanner.nextLine().split(" : ");
        }

        databaseNames.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(e -> {
                    System.out.printf("%s: %d\n", e.getKey(), e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted((f, s) -> f.compareTo(s))
                            .forEach(s -> System.out.printf("-- %s\n", s));
                });
    }
}
