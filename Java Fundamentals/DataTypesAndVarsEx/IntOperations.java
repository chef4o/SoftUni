package DataTypesAndVarsEx;

import java.util.Scanner;

public class IntOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print((scanner.nextInt() + scanner.nextInt()) / scanner.nextInt() * scanner.nextInt());
    }
}
