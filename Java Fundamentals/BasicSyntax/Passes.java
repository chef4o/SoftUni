package BasicSyntax;

import java.util.Locale;
import java.util.Scanner;

public class Passes {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        double grade = new Scanner(System.in).nextDouble();

        if (grade >= 3.0) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}