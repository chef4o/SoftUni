package encapsulationsEx.shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        Validate.name(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validate.amount(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        Validate.moneySufficiency(this.name, this.money, product);
        this.products.add(product);
        this.money -= product.getCost();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (this.products.size() == 0) {
            output.append(String.format("%s - Nothing bought", this.name));
        } else {
            output.append(String.format("%s - %s",
                    this.name, products.stream()
                            .map(Product::getName)
                            .collect(Collectors.joining(", "))));
        }
        return output.toString();
    }
}
