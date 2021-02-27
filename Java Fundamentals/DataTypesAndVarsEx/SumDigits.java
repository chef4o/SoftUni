package DataTypesAndVarsEx;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        int digitsSum = 0;
        while (input > 0) {
            digitsSum += (input % 10);
            input /= 10;
        }

        System.out.print(digitsSum);
    }
}
