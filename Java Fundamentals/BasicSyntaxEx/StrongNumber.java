package BasicSyntaxEx;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        int factorialSum = 0;

        for (int i = 0; i < input.length(); i++) {

            int factorial = 1;
            for (int j = Integer.parseInt(String.valueOf(input.charAt(i))); j > 0; j--) {
                factorial *= j;
            }

            factorialSum += factorial;
        }

        if (factorialSum == Integer.parseInt(input)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
