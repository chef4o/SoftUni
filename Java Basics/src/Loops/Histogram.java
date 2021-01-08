package Loops;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(scan.nextLine());
            if (current < 200) {
                p1++;
            } else if (current <= 399) {
                p2++;
            } else if (current <= 599) {
                p3++;
            } else if (current <= 799) {
                p4++;
            } else {
                p5++;
            }
        }

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%",
                          (p1 / n * 100d),(p2 / n * 100d),(p3 / n * 100d),(p4 / n * 100d),(p5 / n * 100d));
    }
}
