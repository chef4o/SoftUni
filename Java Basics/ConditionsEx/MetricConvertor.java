package ConditionsEx;

import java.util.Scanner;

public class MetricConvertor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());
        String from = scanner.nextLine();
        String to = scanner.nextLine();

        double output = 0d;

        switch (from) {
            case "m":
                if (to.equals("cm")) {
                    output = input * 100;
                } else if (to.equals("mm")) {
                    output = input * 1000;
                }
                break;
            case "cm":
                if (to.equals("m")) {
                    output = input / 100d;
                } else if (to.equals("mm")) {
                    output = input * 10;
                }
                break;
            case "mm":
                if (to.equals("cm")) {
                    output = input / 10d;
                } else if (to.equals("m")) {
                    output = input / 1000d;
                }
                break;
        }

        System.out.printf("%.3f", output);
    }
}
