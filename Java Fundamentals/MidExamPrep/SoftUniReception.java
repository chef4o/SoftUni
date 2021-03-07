package MidExamPrep;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacityPerHour = scanner.nextInt() +  scanner.nextInt() + scanner.nextInt();
        int studentsCount = scanner.nextInt();

        int hoursNeeded = 0;

        while (studentsCount > 0) {
            hoursNeeded++;

            if (hoursNeeded % 4 == 0) {
                hoursNeeded++;
            }

            studentsCount -= capacityPerHour;
        }

        System.out.printf("Time needed: %dh.", hoursNeeded);
    }
}
