package ForLoops;

import java.util.Scanner;

public class LeftSumRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps = scanner.nextInt();

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < steps; i++) {

            leftSum += scanner.nextInt();
        }

        for (int j = 0; j < steps; j++) {

            rightSum += scanner.nextInt();
        }

        if (leftSum == rightSum) {
            System.out.printf("Yes, sum = %d", leftSum);
        } else {
            System.out.printf("No, diff = %d", Math.abs(leftSum - rightSum));
        }
    }
}
