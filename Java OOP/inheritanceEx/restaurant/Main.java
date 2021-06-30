package inheritanceEx.restaurant;

import inheritanceEx.restaurant.beverages.Coffee;
import inheritanceEx.restaurant.beverages.Tea;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Coffee dark = new Coffee("black", 20);
        System.out.println(dark.getPrice());

        Tea tea = new Tea("green", BigDecimal.valueOf(5), 150);
        System.out.println(tea.getMilliliters());
    }
}
