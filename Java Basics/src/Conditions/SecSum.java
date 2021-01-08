package Conditions;

import java.util.Scanner;

public class SecSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lap1 = Integer.parseInt(scan.nextLine());
        int lap2 = Integer.parseInt(scan.nextLine());
        int lap3 = Integer.parseInt(scan.nextLine());

        int mins = (lap1 + lap2 + lap3) / 60;
        int secs = (lap1 + lap2 + lap3) % 60;

        if (secs < 10){
            System.out.printf("%d:0%d", mins, secs);
        }
        else {
            System.out.printf("%d:%d", mins, secs);
        }
    }
}
