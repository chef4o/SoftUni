package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArray = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String equalSumIndex = "no";

        for (int i = 0; i < intArray.length; i++) {

            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += intArray[j];
            }

            int rightSum = 0;
            for (int k = i + 1; k < intArray.length; k++) {
                rightSum += intArray[k];
            }

            if (leftSum == rightSum) {
                equalSumIndex = String.valueOf(i);
            }

        }

        System.out.println(equalSumIndex);
    }
}
