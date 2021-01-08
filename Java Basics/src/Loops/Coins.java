package Loops;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = Integer.parseInt(System.in);

        double input = Double.parseDouble(scanner.nextLine());
        int numberOfCoins = 0;
        String test ;
    

        while (input > 0) {

            numberOfCoins++;

            input = Math.round(input * 100) / 100d;

            if (input >= 2) {
                input -= 2;
            } else if (input >= 1) {
                input -= 1;
            } else if (input >= 0.50) {
                input -= 0.5;
            } else if (input >= 0.20) {
                input -= 0.2;
            } else if (input >= 0.10) {
                input -= 0.1;
            } else if (input >= 0.05) {
                input -= 0.05;
            } else if (input >= 0.02) {
                input -= 0.02;
            } else if (input >= 0.01) {
                input -= 0.01;
            }
        }

        System.out.println(numberOfCoins);
    }
}
