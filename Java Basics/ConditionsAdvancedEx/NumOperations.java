package AdvancedConditionsEx;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NumOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        String operand = scanner.nextLine();

        String evenOrOdd = null;

        switch (operand) {
            case "+":
                if ((a + b) % 2 == 0) {
                    evenOrOdd = "even";
                } else {
                    evenOrOdd = "odd";
                }

                System.out.printf("%d %s %d = %d - %s", a, operand, b, a + b, evenOrOdd);;
                break;
            case "-":
                if ((a - b) % 2 == 0) {
                    evenOrOdd = "even";
                } else {
                    evenOrOdd = "odd";
                }

                System.out.printf("%d %s %d = %d - %s", a, operand, b, a - b, evenOrOdd);
                break;
            case "*":
                if ((a * b) % 2 == 0) {
                    evenOrOdd = "even";
                } else {
                    evenOrOdd = "odd";
                }

                System.out.printf("%d %s %d = %d - %s", a, operand, b, a * b, evenOrOdd);;
                break;
            case "/":
                if (b == 0) {
                    System.out.printf("Cannot divide %d by zero", a);
                    break;
                } else {
                    double output = (double)a / (double)b;

                    System.out.printf("%d %s %d = %.2f", a, operand, b, output);
                }
                break;
            case "%":
                if (b == 0) {
                    System.out.printf("Cannot divide %d by zero", a);
                    break;
                } else {

                    System.out.printf("%d %s %d = %d", a, operand, b, a % b);
                }
                break;
        }
    }
}
