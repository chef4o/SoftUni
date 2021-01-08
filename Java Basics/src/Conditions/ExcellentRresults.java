package Conditions;

import java.util.Scanner;

public class ExcellentRresults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());
        if (input >= 5) {
            System.out.println("Excellent!");
        }
    }
}
