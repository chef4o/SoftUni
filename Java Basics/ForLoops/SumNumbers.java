package ForLoops;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputParameters = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i < inputParameters; i++) {
            sum += scanner.nextInt();
        }

        System.out.println(sum);
    }
}
