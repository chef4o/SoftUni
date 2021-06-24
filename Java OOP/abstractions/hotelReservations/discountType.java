package abstractions.hotelReservations;

public enum discountType {

    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private int percentage;

    discountType(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return this.percentage;
    }

}
