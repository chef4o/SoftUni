package DataTypesAndVarsEx;

import javax.print.DocFlavor;
import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());

        int capacity = 0;
        for (int i = 0; i < cycles; i++) {
            int pouredLiters = Integer.parseInt(scanner.nextLine());

            if (pouredLiters + capacity > 255){
                System.out.println("Insufficient capacity!");
            } else {
                capacity += pouredLiters;
            }
        }

        System.out.println(capacity);
    }
}
