package DataTypes;

import java.math.BigDecimal;
import java.util.Scanner;

public class gbpToUsd {
    public static void main(String[] args) {
        double input = new Scanner(System.in).nextDouble();
        int rate = 131;

        BigDecimal gbp = BigDecimal.valueOf((input * rate) / 100);

        System.out.printf("%.3f", gbp);
    }
}
