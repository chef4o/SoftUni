package DataTypes;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal output = new BigDecimal("0");

        while (n > 0) {

            output = output.add(new BigDecimal(scanner.nextLine()));
            n--;
        }

        System.out.println(output);
    }
}
