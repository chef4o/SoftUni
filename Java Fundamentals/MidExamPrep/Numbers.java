package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int totalValue = 0;
        for (int value: input) {
            totalValue += value;
        }
        double averageValue = (double)totalValue / input.length;

        StringBuilder topFive = new StringBuilder();


    }
}
