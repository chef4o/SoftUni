package BasicSyntaxEx;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupNumber = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine().toLowerCase();
        String day = scanner.nextLine();

        double price = 0d;
        switch (day) {
            case "Friday":
                switch (type) {
                    case "students":
                        price = 8.45;
                        break;
                    case "business":
                        price = 10.90;
                        break;
                    case "regular":
                        price = 15;
                        break;
                }
                break;
            case "Saturday":
                switch (type) {
                    case "students":
                        price = 9.80;
                        break;
                    case "business":
                        price = 15.60;
                        break;
                    case "regular":
                        price = 20;
                        break;
                }
                break;
            case "Sunday":
                switch (type) {
                    case "students":
                        price = 10.46;
                        break;
                    case "business":
                        price = 16;
                        break;
                    case "regular":
                        price = 22.50;
                        break;
                }
                break;
        }

        if (type.equals("students") && groupNumber >= 30) {
            price *= (1 - (15 / 100d));
        } else if (type.equals("regular") && groupNumber >= 10 && groupNumber <= 20) {
            price *= (1 - (5 / 100d));
        } else if (type.equals("business") && groupNumber >= 100) {
            groupNumber -= 10;
        }

        System.out.printf("Total price: %.2f", price * groupNumber);
    }
}
