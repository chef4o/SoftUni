package ForLoopsEx;

import java.util.Scanner;

public class OddEvenPositions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps = Integer.parseInt(scanner.nextLine());

        boolean oddNumbers = false;
        double oddSum = 0d;
        double oddMin = Double.MAX_VALUE;
        double oddMax = Double.NEGATIVE_INFINITY;
        boolean evenNumbers = false;
        double evenSum = 0d;
        double evenMin = Double.MAX_VALUE;
        double evenMax = Double.NEGATIVE_INFINITY;

        for (int i = 1; i <= steps; i++) {

            double currentNum = Double.parseDouble(scanner.nextLine());

            if (i % 2 == 0) {
                evenSum += currentNum;
                evenNumbers = true;
                if (currentNum > evenMax) {
                    evenMax = currentNum;
                }
                if (currentNum < evenMin) {
                    evenMin = currentNum;
                }
            } else {
                oddSum += currentNum;
                oddNumbers = true;
                if (currentNum > oddMax) {
                    oddMax = currentNum;
                }
                if (currentNum < oddMin) {
                    oddMin = currentNum;
                }
            }
        }

        System.out.printf("OddSum=%.2f,\n", oddSum);
        if (oddNumbers) {
            System.out.printf("OddMin=%.2f,\n", oddMin);
            System.out.printf("OddMax=%.2f,\n", oddMax);
        } else {
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
        }
        System.out.printf("EvenSum=%.2f,\n", evenSum);
        if (evenNumbers) {
            System.out.printf("EvenMin=%.2f,\n", evenMin);
            System.out.printf("EvenMax=%.2f\n", evenMax);
        } else {
            System.out.println("EvenMin=No,");
            System.out.println("EvenMax=No");
        }
    }
}
