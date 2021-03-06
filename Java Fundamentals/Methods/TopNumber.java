package Methods;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        printTopNumbersToRange(input);
    }

    static void printTopNumbersToRange(int x) {

        for (int i = 1; i <= x; i++) {

            if (numberHasOddDigit(i) && numberIsDivisible(i)) {
                System.out.println(i);
            }
        }
    }

    static boolean numberHasOddDigit(int x) {

        int testDigit = x % 10;

        while (x > 0) {
            if (testDigit % 2 == 1) {
                return true;
            }
            testDigit = x % 10;
            x /= 10;
        }

        return false;
    }

    static boolean numberIsDivisible(int x) {

        int sumOfDigits = 0;

        while (x > 0) {
            sumOfDigits += x % 10;
            x /= 10;
        }

        if (sumOfDigits % 8 == 0) {
            return true;
        }

        return false;
    }
}
