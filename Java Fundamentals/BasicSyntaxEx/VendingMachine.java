package BasicSyntaxEx;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0d;
        String input = scanner.nextLine();
        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                sum += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {

            double price = 0d;

            switch (input) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    input = scanner.nextLine();
                    continue;
            }

            if (sum - price >= 0) {
                System.out.printf("Purchased %s%n", input);
                sum -= price;
            } else {
                System.out.println("Sorry, not enough money");
            }

            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sum);
    }
}
