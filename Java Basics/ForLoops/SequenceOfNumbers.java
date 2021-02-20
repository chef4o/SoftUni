package ForLoops;

import java.util.Scanner;

public class SequenceOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < input; i++) {

            int currentNum = scanner.nextInt();

            if (currentNum < minNumber) {
                minNumber = currentNum;
            }

            if (currentNum > maxNumber) {
                maxNumber = currentNum;
            }
        }

        System.out.printf("Max number: %d\nMin number: %d", maxNumber, minNumber);
    }
}
