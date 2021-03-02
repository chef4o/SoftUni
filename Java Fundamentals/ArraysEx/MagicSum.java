package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArray = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int givenNumber = scanner.nextInt();

        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] + intArray[j] == givenNumber) {
                    System.out.printf("%d %d%n", intArray[i], intArray[j]);
                }
            }
        }
    }
}

