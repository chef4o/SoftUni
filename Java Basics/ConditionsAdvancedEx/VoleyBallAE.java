package AdvancedConditionsEx;

import java.util.Scanner;

public class VoleyBallAE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String year = scan.nextLine();
        int holidays = Integer.parseInt(scan.nextLine());
        int weekendsInBirthplace = Integer.parseInt(scan.nextLine());

        double totalGames = ((48 - weekendsInBirthplace) * 3/4d) + (holidays * 2/3d) + weekendsInBirthplace;

        if (year.equals("leap")){
            totalGames *= (1 + 15/100d);
        }

        System.out.printf("%.0f", Math.floor(totalGames));
    }
}
