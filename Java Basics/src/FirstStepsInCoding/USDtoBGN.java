package FirstStepsInCoding;

import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double input = Double.parseDouble(scan.nextLine());
        double output = input * 1.79549;

        System.out.println(output);
    }
}
