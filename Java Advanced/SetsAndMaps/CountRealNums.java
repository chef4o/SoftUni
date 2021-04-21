package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> dataBase = new LinkedHashMap<>();

        List<Double> input = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (Double entry : input) {
            if (!dataBase.containsKey(entry)) {
                dataBase.put(entry, 1);
            } else {
                dataBase.put(entry, dataBase.get(entry) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : dataBase.entrySet()) {
            System.out.printf("%.1f -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
