package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArray = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < intArray.length; i++) {

            boolean isTopInt = true;
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] <= intArray[j]) {
                    isTopInt = false;
                    break;
                }
            }

            if (isTopInt) {
                System.out.print(intArray[i] + " ");
            }
        }
    }
}
