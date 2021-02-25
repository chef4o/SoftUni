package BasicSyntaxMoreEx;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lenth = scanner.nextInt();

        while (lenth > 0) {
            int input = scanner.nextInt();

            boolean space = false;
            if (input == 0) {
                space = true;
            }
            int mainDigit = input % 10;

            int numberOfDigits = 0;
            while (input > 0) {
                input /= 10;
                numberOfDigits++;
            }

            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offset++;
            }

            int letterIndex = offset + numberOfDigits - 1;

            if (space) {
                System.out.print(" ");
            } else {
                System.out.print((char)(letterIndex + 97));
            }

            lenth--;
        }
    }
}
