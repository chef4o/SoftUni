package AdvancedConditions;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        double commission = 0d;

        switch (city) {
            case "Sofia":
                if (sales > 0 && sales <= 500) {
                    commission = sales * (5 / 100d);
                } else if (sales > 500 && sales <= 1000) {
                    commission = sales * (7 / 100d);
                } else if (sales > 1000 && sales <= 10000) {
                    commission = sales * (8 / 100d);
                } else if (sales > 10000) {
                    commission = sales * (12 / 100d);
                }
                break;
            case "Varna":
                if (sales > 0 && sales <= 500) {
                    commission = sales * (4.5 / 100d);
                } else if (sales > 500 && sales <= 1000) {
                    commission = sales * (7.5 / 100d);
                } else if (sales > 1000 && sales <= 10000) {
                    commission = sales * (10 / 100d);
                } else if (sales > 10000) {
                    commission = sales * (13 / 100d);
                }
                break;
            case "Plovdiv":
                if (sales > 0 && sales <= 500) {
                    commission = sales * (5.5 / 100d);
                } else if (sales > 500 && sales <= 1000) {
                    commission = sales * (8 / 100d);
                } else if (sales > 1000 && sales <= 10000) {
                    commission = sales * (12 / 100d);
                } else if (sales > 10000) {
                    commission = sales * (14.5 / 100d);
                }
                break;
        }

        if (commission == 0) {
            System.out.println("error");
        } else {
            System.out.printf("%.2f", commission);
        }



    }
}
