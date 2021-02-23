package BasicSyntax;

import java.util.Scanner;

public class TheaterPromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = scanner.nextInt();

        int price = 0;
        switch (day.toLowerCase()) {
            case "weekday":
                if ((age >= 0 && age <= 18) ||
                    (age > 64 && age <=122)) {
                    price = 12;
                } else if (age > 18 && age <= 64) {
                    price = 18;
                }
                break;
            case "weekend":
                if ((age >= 0 && age <= 18) ||
                        (age > 64 && age <=122)) {
                    price = 15;
                } else if (age > 18 && age <= 64) {
                    price = 20;
                }
                break;
            case "holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                } else if (age > 18 && age <= 64) {
                    price = 12;
                } else if (age > 64 && age <= 122) {
                    price = 10;
                }
                break;
            default:
                System.out.println("Error!");
                break;
        }

        if (price != 0) {
            System.out.printf("%d$", price);
        } else {
            System.out.println("Error!");
        }
    }
}
