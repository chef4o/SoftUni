package FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class SortEvenNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(SortEvenNums::isEven)
                .toArray();

        printArray(input);
        Arrays.sort(input);
        printArray(input);
    }

    public static void printArray (int[] array) {

        String output = Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
