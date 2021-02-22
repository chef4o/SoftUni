package ForLoopsEx;

import java.util.Scanner;

public class ElementEqualToHalfTheSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < steps; i++) {

            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (currentNumber > maxNum) {
                maxNum = currentNumber;
            }
            sum += currentNumber;
        }

        if (maxNum == sum - maxNum) {
            System.out.printf("Yes\nSum = %d", maxNum);
        } else {
            System.out.printf("No\nDiff = %d", Math.abs(sum - maxNum * 2));
        }
    }
}
