package SetsAndMapsEx;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> gameDeck = new LinkedHashMap<>();

        String input;
        while (!"JOKER".equals(input = scanner.nextLine())) {

            String[] currentHand = input.split(": ");
            String playerName = currentHand[0];
            List<String> playerCards = Arrays.stream(currentHand[1].
                    split(",\\s+"))
                    .collect(Collectors.toList());

            if (!gameDeck.containsKey(playerName)) {
                gameDeck.put(playerName, new LinkedHashSet<>());
            }

            Set<String> newDeck = gameDeck.get(playerName);
            newDeck.addAll(playerCards);
            gameDeck.replace(playerName, gameDeck.get(playerName));
        }

        for (String player : gameDeck.keySet()) {
            System.out.printf("%s: %d\n", player, GetDeckValue(gameDeck.get(player)));
        }
    }

    private static int GetDeckValue(Set<String> cards) {

        int value = 0;

        for (String card : cards) {

            String cardPower = card.substring(0, card.length() - 1);
            char cardMultiplier = card.charAt(card.length() - 1);

            int power = 0;
            int multiplier = 0;

            switch (cardPower) {
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "10":
                    power = Integer.parseInt(cardPower);
                    break;
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
            }

            switch (cardMultiplier) {
                case 'S':
                    multiplier = 4;
                    break;
                case 'H':
                    multiplier = 3;
                    break;
                case 'D':
                    multiplier = 2;
                    break;
                case 'C':
                    multiplier = 1;
                    break;
            }

            value += power * multiplier;
        }

        return value;
    }
}
