package abstractionsEx.cardsWithPower;

public class Card {

    CardSuit cardSuit;
    CardRank cardRank;
    int cardPower;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
        calculatePower();
    }

    private void calculatePower() {
        this.cardPower = cardSuit.getValue() + cardRank.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.cardRank.name(), this.cardSuit.name(), this.cardPower);
    }
}
