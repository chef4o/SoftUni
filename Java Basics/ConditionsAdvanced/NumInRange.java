package AdvancedConditions;

import java.util.Scanner;

public class NumInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        if (input >= -100
                && input <= 100
                && input != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}