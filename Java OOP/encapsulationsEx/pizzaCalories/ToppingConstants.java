package encapsulationsEx.pizzaCalories;

public enum ToppingConstants {

    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    double modifier;
    ToppingConstants(double modifier) {
        this.modifier = modifier;
    }
}