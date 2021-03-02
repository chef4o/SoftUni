package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLines = scanner.nextInt();

        int[] arrayA = new int[inputLines];
        int[] arrayB = new int[inputLines];

        StringBuilder stringA = new StringBuilder();
        StringBuilder stringB = new StringBuilder();

        for (int i = 0; i < inputLines; i++) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (i % 2 == 0) {
                arrayA[i] = a;
                arrayB[i] = b;
            } else {
                arrayB[i] = a;
                arrayA[i] = b;
            }
        }

        for (int i = 0; i < inputLines; i++) {
            if (i < inputLines - 1) {
                StringBuilder appendA = stringA.append(arrayA[i]).append(" ");
                StringBuilder appendB = stringB.append(arrayB[i]).append(" ");
            } else {
                StringBuilder appendA = stringA.append(arrayA[i]);
                StringBuilder appendB = stringB.append(arrayB[i]);
            }
        }

        System.out.println(stringA);
        System.out.println(stringB);
    }
}
