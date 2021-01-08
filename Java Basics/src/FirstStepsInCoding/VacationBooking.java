package FirstStepsInCoding;

import java.util.Scanner;

public class VacationBooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bookPages = Integer.parseInt(scan.nextLine());
        int pagesNorm = Integer.parseInt(scan.nextLine());
        int daysTarget = Integer.parseInt(scan.nextLine());

        int daysToFinish = bookPages / pagesNorm / daysTarget;

        System.out.println(daysToFinish);
    }
}
