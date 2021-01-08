package FirstStepsInCoding;

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hallRent = Integer.parseInt(scan.nextLine());

        double budget = hallRent +
                        (hallRent * (20 / 100d)) +
                        ((hallRent * (20 / 100d)) * (1 - 45 / 100d)) +
                        (hallRent / 3d);

        System.out.println(budget);
    }
}
