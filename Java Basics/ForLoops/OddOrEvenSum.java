package ForLoops;

import java.util.Scanner;

public class OddOrEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int checks = scanner.nextInt();

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < checks; i++) {
            if (i % 2 == 0) {
                evenSum += scanner.nextInt();
            } else {
                oddSum += scanner.nextInt();
            }
        }

        if (oddSum == evenSum) {
            System.out.printf("Yes\nSum = %d", oddSum);
        } else {
            System.out.printf("No\nDiff = %d", Math.abs(oddSum - evenSum));
        }
    }
}
