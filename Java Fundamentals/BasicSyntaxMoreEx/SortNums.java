package BasicSyntaxMoreEx;

import java.util.Scanner;

public class SortNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);

        int mid = a;
        if ((a == max && b == min)
        || a == min && b == max) {
            mid = c;
        } else if ((a == max) || a == min) {
            mid = b;
        }

        System.out.println(max);
        System.out.println(mid);
        System.out.println(min);
    }
}
