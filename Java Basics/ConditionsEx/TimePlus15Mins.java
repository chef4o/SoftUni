package ConditionsEx;

import java.util.Scanner;

public class TimePlus15Mins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int mins = Integer.parseInt(scanner.nextLine());

        if (mins + 15 < 60) {
            System.out.printf("%d:%d", hour,mins + 15);
        } else {
            mins = (mins + 15 - 60);
            hour++;
            if (hour > 23) {
                hour -= 24;
            }
            if (mins < 10) {
                System.out.printf("%d:0%d", hour,mins);
            } else {
                System.out.printf("%d:%d", hour, mins);
            }
        }
    }
}
