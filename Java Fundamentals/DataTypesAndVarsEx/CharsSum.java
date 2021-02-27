package DataTypesAndVarsEx;

import java.util.Scanner;

public class CharsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loops = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 0; i < loops; i++) {

            char currentChar = scanner.nextLine().charAt(0);
            sum += currentChar;
        }

        System.out.printf("The sum equals: %d", sum);
    }
}
