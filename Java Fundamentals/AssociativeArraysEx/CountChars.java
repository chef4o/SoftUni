package AssociativeArraysEx;

import java.util.*;

public class CountChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> dataSet = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) != ' ') {
                dataSet.putIfAbsent(String.valueOf(input.charAt(i)), 0);
                dataSet.put(String.valueOf(input.charAt(i)), dataSet.get(String.valueOf(input.charAt(i))) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry: dataSet.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}