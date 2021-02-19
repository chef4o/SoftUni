package AdvancedConditionsEx;

import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMins = Integer.parseInt(scanner.nextLine());
        int arrivingHour = Integer.parseInt(scanner.nextLine());
        int arrivingMins = Integer.parseInt(scanner.nextLine());

        int examTime = examHour * 60 + examMins;
        int arrivalTime = arrivingHour * 60 + arrivingMins;

        int hoursDifference = Math.abs(examTime - arrivalTime) / 60;
        int minsDifference = Math.abs(examTime - arrivalTime) % 60;

        if (arrivalTime < examTime - 30) {
            System.out.println("Early");

            if (hoursDifference == 0) {
                System.out.printf("%d minutes before the start", minsDifference);
            } else {

                if (minsDifference < 10) {
                    System.out.printf("%d:0%d hours before the start", hoursDifference, minsDifference);
                } else {
                    System.out.printf("%d:%d hours before the start", hoursDifference, minsDifference);
                }
            }
        } else if (arrivalTime >= examTime - 30 && arrivalTime <= examTime) {
            System.out.println("On time");
                if (examTime != arrivalTime) {
                    System.out.printf("%d minutes before the start", minsDifference);
                }
        } else {
            System.out.println("Late");

            if (hoursDifference == 0) {
                System.out.printf("%d minutes after the start", minsDifference);
            } else {

                if (minsDifference < 10) {
                    System.out.printf("%d:0%d hours after the start", hoursDifference, minsDifference);
                } else {
                    System.out.printf("%d:%d hours after the start", hoursDifference, minsDifference);
                }
            }
        }
    }
}
