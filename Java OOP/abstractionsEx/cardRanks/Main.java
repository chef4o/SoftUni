package abstractionsEx.cardRanks;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CardRank[] rank = CardRank.values();
        System.out.println("Card Ranks:");
        Arrays.stream(rank)
                .forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s\n",
                        e.ordinal(), e.name()));
    }
}
