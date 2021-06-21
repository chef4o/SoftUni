package IteratorsAndComparators.Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(input);
        Iterator<Integer> frog = lake.iterator();

        List<String> output = new ArrayList<>();
        while (frog.hasNext()) {
            output.add(frog.next().toString());
        }

        System.out.println(String.join(", ", output));
    }
}
