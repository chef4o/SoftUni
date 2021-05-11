package SetsAndMapsEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> database = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (!database.containsKey(input.charAt(i))) {
                database.put(input.charAt(i), 0);
            }
            database.put(input.charAt(i), database.get(input.charAt(i)) + 1);
        }

        database.forEach((k, v) -> System.out.printf("%s: %d time/s\n", k, v));
    }
}
