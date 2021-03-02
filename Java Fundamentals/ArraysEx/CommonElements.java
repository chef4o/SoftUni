package ArraysEx;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputA = scanner.nextLine();
        String inputB = scanner.nextLine();

        String[] arrayA = inputA.split(" ");
        String[] arrayB = inputB.split(" ");

        for (int i = 0; i < arrayB.length; i++) {

            for (int j = 0; j < arrayA.length; j++) {
                if (arrayB[i].equals(arrayA[j])) {
                    System.out.print(arrayB[i] + " ");
                }
            }
        }
    }
}
