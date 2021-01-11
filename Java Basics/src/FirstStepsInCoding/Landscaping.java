package FirstStepsInCoding;

import java.util.Scanner;

public class Landscaping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double area = Double.parseDouble(scan.nextLine());

        double finalPrice = (area * 7.61) * (1 - 18 / 100d);
        double discount = (area * 7.61) * (18 / 100d);

        System.out.printf("The final price is: %f lv.", finalPrice);
        System.out.printf("The discount is: %f lv.", discount);
    }
}
