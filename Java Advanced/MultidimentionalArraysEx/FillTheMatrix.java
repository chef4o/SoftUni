package MultidimentionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int matrixSize = Integer.parseInt(input[0]);
        String pattern = input[1].toUpperCase();

        PrintMatrix(MatrixOutput(matrixSize, pattern));
    }

    public static int[][] MatrixOutput(int size, String pattern) {

        int[][] output = new int[size][size];

        switch (pattern) {
            case "A":
                int num = 1;
                for (int col = 0; col < size; col++) {
                    for (int row = 0; row < size; row++) {
                        output[row][col] = num++;
                    }
                }
                break;
            case "B":
                num = 1;
                for (int col = 0; col < size; col++) {
                    if (col % 2 == 0) {
                        for (int row = 0; row < size; row++) {
                            output[row][col] = num++;
                        }
                    } else {
                        for (int row = size - 1; row >= 0; row--) {
                            output[row][col] = num++;
                        }
                    }
                }
                break;
        }

        return output;
    }

    public static void PrintMatrix (int[][] matrix) {

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row)
                    .replaceAll("[\\[\\],]", ""));
        }
    }
}
