package Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextInt();
        long b = scanner.nextInt();

        System.out.printf("%.2f", divisionOfNumbers(factorialOfNumber(a), factorialOfNumber(b)));
    }

    static long factorialOfNumber (long x) {

        long f = 1;
        for (long i = 1; i <= x; i++) {
            f *= i;
        }

        return f;
    }

    static double divisionOfNumbers (long x, long y) {

        return 1d * x / y;
    }
}
