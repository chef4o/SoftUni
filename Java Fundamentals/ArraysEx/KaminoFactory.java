package ArraysEx;

import java.lang.reflect.Array;
import java.net.BindException;
import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequenceLenght = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        int sampleCounter = 0;
        int bestSample = 0;
        String bestDNA = null;
        int bestIndex = sequenceLenght - 1;
        int bestSequence = 0;
        int bestSum = 0;

        while (!input.equals("Clone them!")) {

            String[] dnaSequence = input.split("!+");
            sampleCounter++;

            int minIndex = sequenceLenght - 1;
            int maxSequence = 0;
            int sum = 0;

            for (int i = 0; i < sequenceLenght; i++) {


                if (dnaSequence[i].equals("1")) {
                    sum++;

                    int addSum = 0;

                    String[] subDNA = Arrays.copyOfRange(dnaSequence, i, sequenceLenght);
                    for (int j = 0; j < subDNA.length; j++) {
                        if (subDNA[j].equals("1")) {
                            addSum++;
                        } else {
                            break;
                        }
                    }

                    if (addSum > maxSequence && i < minIndex) {
                        maxSequence = addSum;
                        minIndex = i;
                        bestSum = sum;
                    } else if (addSum > maxSequence) ;
                    {
                        maxSequence = addSum;
                        minIndex = i;
                        bestSum = sum;
                   /* } else if (addSum == maxSequence && sum > bestSum); {
                        bestSum = sum;
                    }*/
                    }

                }

                if (maxSequence > bestSequence) {
                    bestSample = sampleCounter;
                    bestDNA = input;
                    bestSequence = maxSequence;
                    bestSum = sum;
                    bestIndex = minIndex;
                } else if (maxSequence == bestSequence && minIndex < bestIndex) {
                    bestSample = sampleCounter;
                    bestDNA = input;
                    bestSequence = maxSequence;
                    bestSum = sum;
                    bestIndex = minIndex;
                } else if (maxSequence == bestSequence && minIndex == bestIndex && sum > bestSum) {
                    bestSample = sampleCounter;
                    bestDNA = input;
                    bestSequence = maxSequence;
                    bestSum = sum;
                    bestIndex = minIndex;
                }

                input = scanner.nextLine();

            }
        }

        String output = bestDNA.toString().replace("!", " ");
        System.out.printf("Best DNA sample %d with sum: %d.\n", bestSample, bestSum);
        System.out.println(output);
    }
}
