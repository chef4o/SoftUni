package Conditions;

import java.util.Scanner;

public class From100to200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String output = "";

        if (input < 100) {
            output = "Less than 100";
        } else if (input >= 100 && input <= 200) {
            output = "Between 100 and 200";
        } else {
            output = "Greater than 200";
        }

        System.out.println(output);
    }
}
