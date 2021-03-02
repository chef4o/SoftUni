package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class MAxSequenceOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArray = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxSequenceLength = 0;
        int maxSequenceDigit = intArray[0];

        for (int i = 0; i < intArray.length; i++) {
            int sequenceLength = 1;

            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[j] == intArray[i]) {
                    sequenceLength++;
                } else {
                    break;
                }
            }

            if (sequenceLength > maxSequenceLength) {
                maxSequenceDigit = intArray[i];
                maxSequenceLength = sequenceLength;
            }
        }

        for (int i = 0; i < maxSequenceLength; i++) {
            System.out.print(maxSequenceDigit + " ");
        }
    }
}
