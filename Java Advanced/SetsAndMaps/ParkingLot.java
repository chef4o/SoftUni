package SetsAndMaps;

import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> database = new LinkedHashSet<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {

            String[] command = input.split(", ");

            switch (command[0]) {
                case "IN":
                    database.add(command[1]);
                    break;
                case "OUT":
                    database.remove(command[1]);
                    break;
            }
        }

        if (database.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String entry : database) {
                System.out.println(entry);
            }
        }

    }
}
