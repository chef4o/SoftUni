package ConditionsEx;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double movieBudget = Double.parseDouble(scanner.nextLine());
        int actors = Integer.parseInt(scanner.nextLine());
        double clothPrice = Double.parseDouble(scanner.nextLine());

        double decorPrice = movieBudget * (10 / 100d);
        if (actors > 150) {
            clothPrice *= (1 - 10 / 100d);
        }

        double totalCost = clothPrice * actors + decorPrice;

        if (totalCost > movieBudget) {
            System.out.printf("Not enough money!\nWingard needs %.2f leva more.", totalCost - movieBudget);
        } else {
            System.out.printf("Action!\nWingard starts filming with %.2f leva left.", movieBudget - totalCost);
        }
    }
}
