package MidExam;

import java.util.Scanner;

public class NextLevel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededXp = Double.parseDouble(scanner.nextLine());
        short countOfBattles = Short.parseShort(scanner.nextLine());
        double xpEarned = Double.parseDouble(scanner.nextLine());

        boolean reachedNextLevel = false;
        int battlesCounter = 1;
        double xpGained = 0d;

        while (xpGained < neededXp) {

            if (battlesCounter % 15 == 0) {
                xpGained += xpEarned * (1 + 5 / 100d);
            } else if (battlesCounter % 3 == 0) {
                xpGained += xpEarned * (1 + 15 / 100d);
            } else if (battlesCounter % 5 == 0) {
                xpGained += xpEarned * (1 - 10 / 100d);
            } else {
                xpGained += xpEarned;
            }

            if (xpGained >= neededXp) {
                reachedNextLevel = true;
                break;
            }

            if (battlesCounter >= countOfBattles) {
                break;
            }

            xpEarned = Short.parseShort(scanner.nextLine());
            battlesCounter++;
        }

        if (reachedNextLevel) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", battlesCounter);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededXp - xpGained);
        }
    }
}
