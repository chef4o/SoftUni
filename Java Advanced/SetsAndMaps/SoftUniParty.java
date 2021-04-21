package SetsAndMaps;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guestList = new TreeSet<>();

        String input;
        while (!"PARTY".equals(input = scanner.nextLine())) {
            guestList.add(input);
        }

        while (!"END".equals(input = scanner.nextLine())) {

            guestList.remove(input);
        }

        System.out.println(guestList.size());
        for (String guest : guestList) {
            System.out.println(guest);
        }
    }
}
