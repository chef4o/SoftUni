package FirstStepsInCodingEx;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double strawberriesPrice = Double.parseDouble(scanner.nextLine());
        double bananasWeight = Double.parseDouble(scanner.nextLine());
        double orangesWeight = Double.parseDouble(scanner.nextLine());
        double raspberriesWeight = Double.parseDouble(scanner.nextLine());
        double strawberriesWeight = Double.parseDouble(scanner.nextLine());

        double raspberriesPrice = strawberriesPrice / 2d;
        double orangesPrice = raspberriesPrice * (1 - 40 / 100d);
        double bananasPrice = raspberriesPrice * (1 - 80 / 100d);

        double totalPrice = bananasPrice * bananasWeight
               + orangesPrice * orangesWeight
               + raspberriesPrice * raspberriesWeight
               + strawberriesPrice * strawberriesWeight;

        System.out.printf("%.2f", totalPrice);
    }
}
