package ConditionsEx;

import java.util.Scanner;

public class SwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentRecord = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timePerMeter = Double.parseDouble(scanner.nextLine());

        double timeToFinish = timePerMeter * distance;
        int delay = (int)distance / 15;
        timeToFinish += delay * 12.5;

        if (timeToFinish < currentRecord) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeToFinish);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeToFinish - currentRecord);
        }
    }
}
