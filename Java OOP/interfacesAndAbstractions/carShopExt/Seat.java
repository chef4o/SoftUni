package interfacesAndAbstractions.carShopExt;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String country, Double price) {
        super(model, color, horsePower, country);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        output.append(System.lineSeparator());
        output.append(String.format("%s sells for %f", getModel(), this.price));
        return output.toString();
    }
}
