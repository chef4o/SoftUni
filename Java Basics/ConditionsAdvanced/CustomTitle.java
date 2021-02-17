package AdvancedConditions;

import java.util.Scanner;

public class CustomTitle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        String sex = scanner.nextLine();

        switch (sex) {
            case "m":
                if (age >= 16) {
                    System.out.println("Mr.");
                } else {
                    System.out.println("Master");
                }
                break;
            case "f":
                if (age >= 16) {
                    System.out.println("Ms.");
                } else {
                    System.out.printf("Miss");
                }
                break;
        }
    }
}
