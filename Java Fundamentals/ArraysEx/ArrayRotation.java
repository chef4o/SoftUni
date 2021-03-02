package ArraysEx;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            String tempValue = input[0];
            for (int j = 0; j < input.length - 1; j++) {
                input[j] = input[j + 1];
            }
            input[input.length - 1] = tempValue;
        }

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
