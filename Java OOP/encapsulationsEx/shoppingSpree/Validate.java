package encapsulationsEx.shoppingSpree;

public class Validate {

    public static void amount(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public static void name(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public static void moneySufficiency(String name, double money, Product product) {
        if (product.getCost() > money) {
            throw new IllegalStateException(String.format("%s can't afford %s", name, product.getName()));
        }
    }
}