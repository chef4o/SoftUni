package FirstStepsInCodingEx;

import java.util.Scanner;

public class DepositCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int depositSum = Integer.parseInt(scan.nextLine());
        int depositPeriod = Integer.parseInt(scan.nextLine());
        double interestRate = Double.parseDouble(scan.nextLine());

        double  output = depositSum + ((depositSum * (interestRate / 100d) / 12) * depositPeriod);

        System.out.println(output);
    }
}
