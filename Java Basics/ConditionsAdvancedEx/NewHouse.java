package AdvancedConditionsEx;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowersType = scanner.nextLine();
        short flowersCount = Short.parseShort(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        double flowersPrice = 0d;

        switch (flowersType) {
            case "Roses":
                flowersPrice = flowersCount * 5;
                if (flowersCount > 80) {
                    flowersPrice *= (1 - 10 / 100d);
                }
                break;
            case "Dahlias":
                flowersPrice = flowersCount * 3.8;
                if (flowersCount > 90) {
                    flowersPrice *= (1 - 15 / 100d);
                }
                break;
            case "Tulips":
                flowersPrice = flowersCount * 2.8;
                if (flowersCount > 80) {
                    flowersPrice *= (1 - 15 / 100d);
                }
                break;
            case "Narcissus":
                flowersPrice = flowersCount * 3;
                if (flowersCount < 120) {
                    flowersPrice *= (1 + 15 / 100d);
                }
                break;
            case "Gladiolus":
                flowersPrice = flowersCount * 2.5;
                if (flowersCount < 80) {
                    flowersPrice *= (1 + 20 / 100d);
                }
                break;
        }

        if (flowersPrice <= budget) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                    flowersCount, flowersType, budget - flowersPrice);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", flowersPrice - budget);
        }
    }
}
