package DataTypesAndVarsEx;

import java.util.Scanner;

public class SpicyBusiness {
    public static void main(String[] args) {
        int extractPerDay = new Scanner(System.in).nextInt();

        int daysOfOperation = 0;
        int extractedAmount = 0;

        while (extractPerDay >= 100) {
            daysOfOperation++;
            extractedAmount += extractPerDay;
            extractPerDay -= 10;
            extractedAmount -= 26;
        }

        if (extractedAmount >= 26) {
            extractedAmount -= 26;
        }

        System.out.printf("%d%n%d", daysOfOperation, extractedAmount);
    }
}
