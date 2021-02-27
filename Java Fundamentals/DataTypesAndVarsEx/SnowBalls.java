package DataTypesAndVarsEx;

import java.util.Scanner;

public class SnowBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTests = Integer.parseInt(scanner.nextLine());

        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;
        double bestSnowballValue = 0;

        for (int i = 0; i < numberOfTests; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.round(Math.pow((1d * snowballSnow / snowballTime), snowballQuality));

            if (snowballValue >= bestSnowballValue) {
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bestSnowballQuality = snowballQuality;
                bestSnowballValue = snowballValue;
            }
        }

        System.out.printf("%d : %d = %d (%d)", bestSnowballSnow, bestSnowballTime, Math.round(bestSnowballValue), bestSnowballQuality);
    }
}
