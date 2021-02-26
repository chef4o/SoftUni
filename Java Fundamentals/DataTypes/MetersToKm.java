package DataTypes;

import java.util.Scanner;

public class MetersToKm {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        System.out.printf("%.2f", (double)input / 1000);
    }
}

