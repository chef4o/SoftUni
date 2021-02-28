package AssociativeArrays;

import java.util.*;

public class OddOccurencies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().toLowerCase().split(" ");

        Map<String, Integer> data = new LinkedHashMap<>();

        for (String item:input) {

            data.putIfAbsent(item, 0);
            data.put(item, data.get(item) + 1);
        }

        List<String> output = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: data.entrySet()) {

                if (entry.getValue() % 2 != 0) {
                    output.add(entry.getKey());
                }
        }

        System.out.println(output.toString().replaceAll("[\\[\\]]", ""));
    }
}
