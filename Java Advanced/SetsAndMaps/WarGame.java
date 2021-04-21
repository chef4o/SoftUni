package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class WarGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> playerOneDeck = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> playerTwoDeck = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rows = 50;
        while (rows-- > 0 &&
                !playerOneDeck.isEmpty() && !playerTwoDeck.isEmpty()) {

            int playerOneCard = playerOneDeck.iterator().next();
            int playerTwoCard = playerTwoDeck.iterator().next();

            playerOneDeck.remove(playerOneCard);
            playerTwoDeck.remove(playerTwoCard);

            if (playerOneCard > playerTwoCard) {
                playerOneDeck.add(playerOneCard);
                playerOneDeck.add(playerTwoCard);
            } else if (playerTwoCard > playerOneCard) {
                playerTwoDeck.add(playerOneCard);
                playerTwoDeck.add(playerTwoCard);
            }
        }

        if (playerOneDeck == playerTwoDeck) {
            System.out.println("Draw!");
        } else if (playerOneDeck.size() > playerTwoDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}