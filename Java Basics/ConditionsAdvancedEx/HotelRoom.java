package AdvancedConditionsEx;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        double apartmentPrice = 0d;
        double studioPrice = 0d;

        switch (month) {
            case "May":
            case "October":
                studioPrice = nights * 50;
                apartmentPrice = nights * 65;

                if (nights > 7 && nights <= 14) {
                    studioPrice *= (1 - 5 / 100d);
                } else if (nights > 14) {
                    studioPrice *= (1 - 30 / 100d);
                    apartmentPrice *= (1 - 10 / 100d);
                }
                break;
            case "June":
            case "September":
                studioPrice = nights * 75.20;
                apartmentPrice = nights * 68.70;

                if (nights > 14) {
                    studioPrice *= (1 - 20 / 100d);
                    apartmentPrice *= (1 - 10 / 100d);
                }
                break;
            case "July":
            case "August":
                studioPrice = nights * 76;
                apartmentPrice = nights * 77;

                if (nights > 14) {
                    apartmentPrice *= (1 - 10 / 100d);
                }
                break;
        }

        System.out.printf("Apartment: %.2f lv.\nStudio: %.2f lv.", apartmentPrice, studioPrice);
    }
}
