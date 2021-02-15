package Conditions;

import java.util.Scanner;

public class ToyStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzleCount = Integer.parseInt(scanner.nextLine());
        int speakingDollCount = Integer.parseInt(scanner.nextLine());
        int teddyBearCount = Integer.parseInt(scanner.nextLine());
        int minionCount = Integer.parseInt(scanner.nextLine());
        int truckCount = Integer.parseInt(scanner.nextLine());

        double puzzlesPrice = puzzleCount * 2.60;
        double speakingDolls = speakingDollCount * 3d;
        double teddyBears = teddyBearCount * 4.10;
        double minions = minionCount * 8.20;
        double trucks = truckCount * 2d;

        double totalPrice = (puzzlesPrice + speakingDolls + teddyBears + minions + trucks);
        double totalCount = (puzzleCount + speakingDollCount + teddyBearCount + minionCount + truckCount);

        if (totalCount >= 50) {
            totalPrice *= (1 - 25 / 100d);
        }

        if ((totalPrice * (1 - 10 / 100d) >= tripPrice)) {
            System.out.printf("Yes! %.2f lv left.", totalPrice * (1 - 10 / 100d) - tripPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrice - totalPrice * (1 - 10 / 100d));
        }
    }
}
