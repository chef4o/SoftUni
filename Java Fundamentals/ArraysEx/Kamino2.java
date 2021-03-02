package ArraysEx;

import javax.print.DocFlavor;
import java.util.Scanner;

public class Kamino2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dnaLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int bestIndex = Integer.MAX_VALUE;
        int bestDnaSample = Integer.MAX_VALUE;
        int bestSequenceLength = Integer.MIN_VALUE;
        String bestDnaString = null;
        int mostOneValues = 0;

        int sampleCounter = 0;
        while (!input.equals("Clone them!")) {

            String[] localDnaSample = input.split("!+");
            sampleCounter++;

            int betterIndex = Integer.MAX_VALUE;
            int betterSequence = Integer.MIN_VALUE;
            int oneValues = 0;
            for (int i = 0; i < localDnaSample.length; i++) {

                if (localDnaSample[i].equals("1")) {

                    int localIndex = i;
                    int localSequence = 1;
                    oneValues++;

                    for (int j = i + 1; j < localDnaSample.length - 1; j++) {
                        if (localDnaSample[j].equals("1")) {
                            localSequence++;
                            oneValues++;

                            if (oneValues > mostOneValues) {
                                mostOneValues = oneValues;
                            }

                            if (localSequence > betterSequence) {
                                betterSequence = localSequence;
                            } else if (localSequence == betterSequence && localIndex < betterIndex) {
                                betterIndex = localIndex;
                            }

                        } else {
                            betterSequence = localSequence;
                            localSequence = 0;
                            break;
                        }
                    }
                }
            }

            if (betterSequence > bestSequenceLength) {
                bestDnaSample = sampleCounter;
                bestSequenceLength = betterSequence;
                bestDnaString = input;
            } else if (betterSequence == bestSequenceLength && betterIndex < bestIndex) {
                bestDnaSample = sampleCounter;
                bestSequenceLength = betterSequence;
                bestDnaString = input;
            } else if (betterSequence == bestSequenceLength && betterIndex == bestIndex && oneValues > mostOneValues) {
                bestDnaSample = sampleCounter;
                bestSequenceLength = betterSequence;
                bestDnaString = input;
            }

            input = scanner.nextLine();
        }

        String[] bestDnaCode = bestDnaString.split("!+");

        System.out.printf("Best DNA sample %d with sum: %d.\n", bestDnaSample, bestSequenceLength);
        System.out.println(String.join(" ", bestDnaCode));
    }
}
