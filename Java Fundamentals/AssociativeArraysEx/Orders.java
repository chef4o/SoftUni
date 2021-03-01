package AssociativeArraysEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> itemsCount = new LinkedHashMap<>();
        Map<String, Double> itemsPrice = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("buy")) {

            String currentItem = input[0];
            double currentPrice = Double.parseDouble(input[1]);
            int currentCount = Integer.parseInt(input[2]);

            if (!itemsCount.containsKey(currentItem)) {
                itemsCount.put(currentItem, currentCount);
                itemsPrice.put(currentItem, currentPrice * currentCount);
            } else {
                itemsCount.put(currentItem, itemsCount.get(currentItem) + currentCount);
                itemsPrice.put(currentItem, itemsCount.get(currentItem) * currentPrice);
            }

            input = scanner.nextLine().split(" ");
        }

        for (Map.Entry<String, Double> entry:itemsPrice.entrySet()) {

            System.out.printf("%s -> %.2f\n", entry.getKey(), entry.getValue());
        }
    }
}
