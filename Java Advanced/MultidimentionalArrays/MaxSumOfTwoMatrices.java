package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = loadIntMatrix(scanner, ",\\s+");

        int[][] output = new int[2][2];
        int outputSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {

                if (SquareSum(matrix, row, col) > outputSum) {

                    output = GenerateOutput(matrix, row, col);
                    outputSum = SquareSum(matrix, row, col);
                }
            }
        }

        for (int[] row : output) {
            for (int col : row) {
                System.out.printf("%d ", col);
            }
            System.out.println();
        }

        System.out.println(outputSum);
    }

    public static int[][] GenerateOutput (int[][] matrix, int row, int col) {

        int[][] output = new int[2][2];

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {
                output[i][j] = matrix[row + i][col + j];
            }
        }

        return output;
    }

    public static int SquareSum (int[][] matrix, int row, int col) {

        return matrix[row][col] + matrix[row][col + 1]
                + matrix[row + 1][col] + matrix[row + 1][col + 1];
    }

    public static int[][] loadIntMatrix (Scanner scanner, String path) {

        int[] matrixDimensions = Arrays.stream(scanner.nextLine()
                .split(path))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[matrixDimensions[0]][matrixDimensions[1]];

        for (int row = 0; row < matrixDimensions[0]; row++) {

            int[] matrixColumn = Arrays.stream(scanner.nextLine()
                    .split(path))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < matrixColumn.length; col++) {

                matrix[row][col] = matrixColumn[col];
            }
        }

        return matrix;
    }
}
