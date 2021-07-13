package encapsulationsEx.shoppingSpree;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    private void setCost(double cost) {
        Validate.amount(cost);
        this.cost = cost;
    }

    private void setName(String name) {
        Validate.name(name);
        this.name = name;
    }
}
