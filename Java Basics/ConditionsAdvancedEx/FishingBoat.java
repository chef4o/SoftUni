package AdvancedConditionsEx;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermen = Integer.parseInt(scanner.nextLine());

        double boatPrice = 0;

        switch (season) {
            case "Spring":
                boatPrice = 3000;
                break;
            case "Summer":
            case "Autumn":
                boatPrice = 4200;
                break;
            case "Winter":
                boatPrice = 2600;
                break;
        }

        if (fishermen <= 6) {
            boatPrice *= (1 - 10 / 100d);
        } else if (fishermen <= 11) {
            boatPrice *= (1 - 15 / 100d);
        } else {
            boatPrice *= (1 - 25 / 100d);
        }

        if (fishermen % 2 == 0 && !season.equals("Autumn")) {
            boatPrice *= (1 - 5 / 100d);
        }

        if (budget >= boatPrice) {
            System.out.printf("Yes! You have %.2f leva left.", budget - boatPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", boatPrice - budget);
        }
    }
}
