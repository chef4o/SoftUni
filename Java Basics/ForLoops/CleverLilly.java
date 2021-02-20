package ForLoops;

import java.util.Scanner;

public class CleverLilly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short age = Short.parseShort(scanner.nextLine());
        double machinePrice = Double.parseDouble(scanner.nextLine());
        byte toyPrice = Byte.parseByte(scanner.nextLine());

        double raisedFunds = 0d;
        int bulk = 0;
        int toys = 0;

        for (int i = 1; i <= age; i++) {

            if (i % 2 != 0) {
                toys++;
            } else {
                bulk += 10;
                raisedFunds += bulk;
                raisedFunds--;
            }
        }

        raisedFunds += toys * toyPrice;

        if (raisedFunds >= machinePrice) {
            System.out.printf("Yes! %.2f", raisedFunds - machinePrice);
        } else {
            System.out.printf("No! %.2f", machinePrice - raisedFunds);
        }
    }
}
