package abstractions.hotelReservations;

public class priceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private abstractions.hotelReservations.discountType discountType;
    private abstractions.hotelReservations.season season;

    public priceCalculator(double pricePerDay,
                           int numberOfDays,
                           abstractions.hotelReservations.season season,
                           abstractions.hotelReservations.discountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double makeCalculations() {
        return pricePerDay
                * numberOfDays
                * season.getMultiplier()
                * (1 - (discountType.getPercentage() / 100d)) ;
    }
}
