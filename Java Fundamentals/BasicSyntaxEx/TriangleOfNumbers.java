package BasicSyntaxEx;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        for (int i = 1; i <= input; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", i);
            }

            System.out.println();
        }
    }
}
