package AssociativeArraysEx;

import java.util.*;

public class StudentAcademy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int records = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> database = new HashMap<>();

        for (int i = 0; i < records; i++) {

            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!database.containsKey(name)) {
                database.put(name, new ArrayList<>());
            }

            database.get(name).add(grade);
        }

        database.entrySet()
                .stream()
                .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.5)
                .sorted((x, y) -> {
                    double firstValue = x.getValue()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .getAsDouble();
                    double secondValue = y.getValue()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .getAsDouble();
                    return Double.compare(secondValue, firstValue);
                }).forEach(e -> System.out.printf("%s -> %.2f\n",
                                                    e.getKey(),
                                                    e.getValue().stream()
                                                                .mapToDouble(Double::doubleValue)
                                                                .average()
                                                                .getAsDouble()));
    }
}
