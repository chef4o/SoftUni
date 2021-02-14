package FirstStepsInCodingEx;

import java.util.Scanner;

public class RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double rad = Double.parseDouble(scan.nextLine());
        double degree = rad * 180f / Math.PI;

        System.out.printf("%.0f", degree);
    }
}
