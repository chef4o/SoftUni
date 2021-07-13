package encapsulationsEx.pizzaCalories;

public enum DoughConstants {

    WHOLEGRAIN(1.0),
    WHITE(1.5),

    CRISPY(0.9),
    HOMEMADE(1.0),
    CHEWY(1.1);

    double modifier;
    DoughConstants(double modifier) {
        this.modifier = modifier;
    }
}
