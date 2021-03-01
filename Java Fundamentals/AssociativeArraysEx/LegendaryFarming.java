package AssociativeArraysEx;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryItems = new TreeMap<>();
        legendaryItems.put("shards", 0);
        legendaryItems.put("fragments", 0);
        legendaryItems.put("motes", 0);

        Map<String, Integer> junkItems = new TreeMap<>();

        boolean legendaryItemNotObtained = true;

        while (legendaryItemNotObtained) {

            String[] input = scanner.nextLine().toLowerCase().split(" ");

            for (int i = 1; i < input.length; i += 2) {

                if (input[i].equals("shards")
                        || input[i].equals("fragments")
                        || input[i].equals("motes")) {

                    legendaryItems.put(input[i], legendaryItems.get(input[i]) + Integer.parseInt(input[i - 1]));

                    if (legendaryItems.get(input[i]) >= 250) {
                        legendaryItemNotObtained = false;
                        legendaryItems.put(input[i], legendaryItems.get(input[i]) - 250);
                        switch ((input[i])) {
                            case "shards" -> System.out.println("Shadowmourne obtained!");
                            case "fragments" -> System.out.println("Valanyr obtained!");
                            case "motes" -> System.out.println("Dragonwrath obtained!");
                        }
                        break;
                    }
                } else {

                    junkItems.putIfAbsent(input[i], 0);
                    junkItems.put(input[i], junkItems.get(input[i]) + Integer.parseInt(input[i - 1]));
                }
            }
        }

        legendaryItems.entrySet()
                .stream()
                .sorted((a , b) -> {
                     int res = b.getValue().compareTo(a.getValue());
                     if (res == 0) {
                         res = a.getKey().compareTo(b.getKey());
                     }
                     return res;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkItems.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
