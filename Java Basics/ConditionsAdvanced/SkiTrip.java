package AdvancedConditions;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String rating = scanner.nextLine();

        double price = 0d;

        days -= 1;
        switch (roomType) {
            case "room for one person":
                price = days * 18;
                break;
            case "apartment":
                if (days > 0 && days < 10) {
                    price = days * 25 * (1 - 30 / 100d);
                } else if (days >= 10 && days <= 15) {
                    price = days * 25 * (1 - 35 / 100d);
                } else if (days > 15) {
                    price = days * 25 * (1 - 50 / 100d);
                }
                break;
            case "president apartment":
                if (days > 0 && days < 10) {
                    price = days * 35 * (1 - 10 / 100d);
                } else if (days >= 10 && days <= 15) {
                    price = days * 35 * (1 - 15 / 100d);
                } else if (days > 15) {
                    price = days * 35 * (1 - 20 / 100d);
                }
                break;
        }

        if (rating.equals("positive")) {
            price += price * (25 / 100d);
        } else {
            price -= price * (10 / 100d);
        }

        System.out.printf("%.2f", price);
    }
}
