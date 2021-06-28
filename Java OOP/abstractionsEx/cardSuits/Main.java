package abstractionsEx.cardSuits;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CardSuit[] suit = CardSuit.values();
        System.out.println("Card Suits:");
        Arrays.stream(suit)
                .forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s\n",
                        e.ordinal(), e.name()));
    }
}
