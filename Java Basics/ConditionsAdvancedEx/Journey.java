package AdvancedConditionsEx;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = null;
        if (budget <= 100) {
            destination = "Bulgaria";
        } else if (budget > 100 && budget <= 1000) {
            destination = "Balkans";
        } else {
            destination = "Europe";
        }

        String accommodation = null;
        if (season.equals("summer")
                && !destination.equals("Europe")) {
            accommodation = "Camp";
        } else {
            accommodation = "Hotel";
        }

        double destinationPrice = 0d;
        switch (destination) {
            case "Bulgaria":
                if (season.equals("summer")) {
                    destinationPrice = budget * (30 / 100d);
                } else {
                    destinationPrice = budget * (70 / 100d);
                }
                break;
            case "Balkans":
                if (season.equals("summer")) {
                    destinationPrice = budget * (40 / 100d);
                } else {
                    destinationPrice = budget * (80 / 100d);
                }
                break;
            case "Europe":
                destinationPrice = budget * (90 / 100d);
                break;
        }

        System.out.printf("Somewhere in %s\n%s - %.2f", destination, accommodation, destinationPrice);
    }
}
