package AssociativeArraysEx;

import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());

        Map<String, String> database = new LinkedHashMap<>();

        for (int i = 0; i < cycles; i++) {

            String[] input = scanner.nextLine().split(" ");

            String command = input[0];
            String name = input[1];

            switch (command) {
                case "register":
                    String plate = input[2];

                    if (database.containsKey(name)) {
                        System.out.printf("ERROR: already registered with plate number %s\n", plate);
                    } else {
                        database.put(name, plate);
                        System.out.printf("%s registered %s successfully\n", name, plate);
                    }
                    break;
                case "unregister":
                    if (!database.containsKey(name)) {
                        System.out.printf("ERROR: user %s not found\n", name);
                    } else {
                        database.remove(name);
                        System.out.printf("%s unregistered successfully\n", name);
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry: database.entrySet()) {
            System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
        }
    }
}
