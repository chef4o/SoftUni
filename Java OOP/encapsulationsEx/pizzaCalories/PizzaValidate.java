package encapsulationsEx.pizzaCalories;

import java.util.Arrays;

public class PizzaValidate {

    public static void pizzaName(String input) {
        if (input == null || input.trim().isEmpty() || input.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void toppingsCount(int toppings) {
        if (toppings < 0 || toppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public static void doughCharacteristics(String input) {
        if (input == null || input.trim().isEmpty()
                || !Arrays.toString(DoughConstants.values()).contains(input.toUpperCase())) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void doughWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public static void toppingType(String topping) {
        if (!Arrays.toString(ToppingConstants.values()).contains(topping.toUpperCase())) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", topping));
        }
    }

    public static void toppingWeight(String topping, double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(topping + " weight should be in the range [1..50].");
        }
    }
}
