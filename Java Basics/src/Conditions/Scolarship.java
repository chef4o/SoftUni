package Conditions;

import java.util.Scanner;

public class Scolarship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double income = Double.parseDouble(scan.nextLine());
        double averageGrade = Double.parseDouble(scan.nextLine());
        double minWage = Double.parseDouble(scan.nextLine());

        double socialScolarshipSize = minWage * 35 / 100.0;
        double excellentScolarshipSize = averageGrade * 25;

        boolean socialScolarship = income <= minWage && averageGrade >= 4.5;
        boolean excelentScolarship = averageGrade >= 5.5;

        if ((socialScolarship && !excelentScolarship) ||
            (socialScolarship && socialScolarshipSize > excellentScolarshipSize)) {
            System.out.printf("You get a Social scholarship %.0f BGN", socialScolarshipSize);
        } else if ((!socialScolarship && excelentScolarship) ||
                   (socialScolarship && socialScolarshipSize <= excellentScolarshipSize)) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", excellentScolarshipSize);
        } else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}
