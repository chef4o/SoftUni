package ConditionsEx;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        double bonus = 0d;

        if (input <= 100) {
            bonus = 5;
        } else if (input <= 1000) {
            bonus = input * 20 / 100d;
        } else {
            bonus = input * 10 / 100d;
        }

        if (input % 2 == 0) {
            bonus += 1;
        } else if (input % 5 == 0) {
            bonus += 2;
        }

        System.out.printf("%.1f\n%.1f", bonus, input + bonus    );
    }
}
