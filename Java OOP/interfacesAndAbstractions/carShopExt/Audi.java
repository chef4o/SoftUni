package interfacesAndAbstractions.carShopExt;

public class Audi extends CarImpl implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String country, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, country);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        output.append(System.lineSeparator());
        output.append(String.format("Minimum rental period of %d days. Price per day %f",
                this.minRentDay, this.pricePerDay));
        return output.toString();
    }
}
