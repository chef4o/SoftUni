package BasicSyntaxMoreEx;

import java.util.Scanner;

public class GameStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double startingBudget = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        double moneySpent = 0;

        while (!input.equals("Game Time") && moneySpent < startingBudget) {

            double price = 0;
            boolean gameInStock = true;

            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                default:
                    gameInStock = false;
                    System.out.println("Not Found");
                    break;
            }

            if (price > startingBudget - moneySpent && gameInStock) {
                System.out.println("Too Expensive");
            } else if (gameInStock) {
                System.out.printf("Bought %s\n", input);
                moneySpent += price;
            }

            if (moneySpent >= startingBudget) {
                System.out.println("Out of money!");
                break;
            }

            input = scanner.nextLine();
        }

        if (startingBudget > moneySpent) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneySpent, startingBudget - moneySpent);
        }
    }
}
