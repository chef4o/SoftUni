package DataTypesAndVarsEx;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = scanner.nextInt();
        int rounds = scanner.nextInt();

        System.out.printf("%.0f", Math.ceil((double)people / rounds));
    }
}
