package BasicSyntax;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int multiplier = scanner.nextInt();

        for (int i = multiplier; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", input, i, input * i);
        }

        if (multiplier > 10) {
            System.out.printf("%d X %d = %d", input, multiplier, input * multiplier);
        }
    }
}
