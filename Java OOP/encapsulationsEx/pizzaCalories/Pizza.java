package encapsulationsEx.pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int toppings) {
        this.setName(name);
        this.setToppings(toppings);
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        PizzaValidate.pizzaName(name);
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int toppings) {
        PizzaValidate.toppingsCount(toppings);
        this.numberOfToppings = toppings;
    }

    public void addTopping (Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        return dough.calculateCalories() + toppings.stream()
                                                    .mapToDouble(Topping::calculateCalories)
                                                    .sum();
    }
}
