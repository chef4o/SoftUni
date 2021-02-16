package ConditionsEx;

import java.util.Scanner;

public class    Scholarship {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double income = Double.parseDouble(scanner.nextLine());
        double averageGrade = Double.parseDouble(scanner.nextLine());
        double minSalary = Double.parseDouble(scanner.nextLine());

        double socialScholarship = 0;
        double excellentScholarship = 0;

        if (averageGrade <= 4.50) {
            System.out.println("You cannot get a scholarship!");
        } else if (averageGrade < 5.50) {

            if (income < minSalary) {
                socialScholarship = Math.floor(0.35 * minSalary);
                System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
            } else {
                System.out.println("You cannot get a scholarship!");
            }
        } else {

            excellentScholarship = Math.floor(averageGrade * 25);
            if (income < minSalary) socialScholarship = Math.floor(0.35 * minSalary);

            if (socialScholarship > excellentScholarship) {
                System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
            } else {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", excellentScholarship);
            }
        }
    }
}
