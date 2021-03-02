package ArraysEx;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            System.out.print(array[i] + " ");
            sum += array[i];
        }

        System.out.println("\n" + sum);
    }
}
