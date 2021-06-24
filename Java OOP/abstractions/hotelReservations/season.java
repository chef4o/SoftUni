package abstractions.hotelReservations;

public enum season {

    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int multiplier;
    season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return this.multiplier;
    }
}
