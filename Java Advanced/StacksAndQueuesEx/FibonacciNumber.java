package StacksAndQueuesEx;

import java.util.Scanner;

public class FibonacciNumber {

    private static long[] fn;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        fn = new long[n + 1];

        System.out.println(FibonacciMemoization(n));
    }

    public static long FibonacciMemoization (int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (fn[n] != 0) {
            return fn[n];
        }

        fn[n] = FibonacciMemoization(n - 1) + FibonacciMemoization(n - 2);

        return fn[n];
    }
}
