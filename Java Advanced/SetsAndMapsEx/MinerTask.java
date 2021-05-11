package SetsAndMapsEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String input;
        while (!"stop".equals(input = scanner.nextLine())) {

            if (!resources.containsKey(input)) {

                resources.put(input, Integer.parseInt(scanner.nextLine()));
            } else {

                resources.put(input, resources.get(input) + Integer.parseInt(scanner.nextLine()));
            }
        }

        for (String entry : resources.keySet()) {
            System.out.printf("%s -> %d\n", entry, resources.get(entry));
        }
    }
}
