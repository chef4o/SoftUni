package AssociativeArraysEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            if (!resources.containsKey(input)) {
                resources.put(input, 0);
            }

            resources.put(input, resources.get(input) + Integer.parseInt(scanner.nextLine()));

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry: resources.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
