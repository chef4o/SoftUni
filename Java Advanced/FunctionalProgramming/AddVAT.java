package FunctionalProgramming;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vatCalc = sum -> sum * 1.2;

        List<Double> prices = Arrays.stream(scanner.nextLine()
                                            .split(",\\s+"))
                                            .map(Double::parseDouble)
                                            .collect(Collectors.toList());

        System.out.println("Prices with VAT:");
        prices.forEach(e -> System.out.printf("%.2f%s", vatCalc.apply(e), System.lineSeparator()));
    }
}
