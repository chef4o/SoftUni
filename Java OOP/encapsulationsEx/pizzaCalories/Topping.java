package encapsulationsEx.pizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String topping) {
        PizzaValidate.toppingType(topping);
        this.toppingType = topping;
    }

    private void setWeight(double weight) {
        PizzaValidate.toppingWeight(this.toppingType, weight);
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * weight) * ToppingConstants.valueOf(toppingType.toUpperCase()).modifier;
    }
}
