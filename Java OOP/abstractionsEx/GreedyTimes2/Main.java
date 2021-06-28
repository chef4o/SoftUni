package abstractionsEx.GreedyTimes2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        Bag bag = new Bag(bagCapacity);

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i += 2) {
            String token = input[i];
            long quantity = Long.parseLong(input[i + 1]);

            if (token.length() == 3) {
                Cash currency = new Cash(token, quantity);
                currency.addCash(bag);
            } else if (token.toLowerCase().endsWith("gem")) {
                Gem gem = new Gem(token, quantity);
                gem.addGem(bag);
            } else if (token.toLowerCase().equals("gold")) {
                Gold gold = new Gold(quantity);
                gold.addGold(bag);
            }
        }
        System.out.println(bag.toString());
    }
}
