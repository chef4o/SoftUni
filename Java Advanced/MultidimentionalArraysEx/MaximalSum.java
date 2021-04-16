package MultidimentionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRows = matrixDimensions[0];
        int matrixCols = matrixDimensions[1];

        int[][] matrix = FillMatrix(scanner, matrixRows, matrixCols);

        int maxMatrixSum = Integer.MIN_VALUE;
        int maxMatrixStartRow = 0;
        int maxMatrixStartCol = 0;

        for (int row = 0; row <= matrixRows - 3; row++) {
            for (int col = 0; col <= matrixCols - 3; col++) {

                int elementsSum = MatrixSum(matrix, row, col);
                if (elementsSum > maxMatrixSum) {
                    maxMatrixSum = elementsSum;
                    maxMatrixStartRow = row;
                    maxMatrixStartCol = col;
                }
            }
        }

        Print(ExportedMatrix(matrix, maxMatrixStartRow, maxMatrixStartCol), maxMatrixSum);
    }

    public static void Print(int[][] matrix, int sum) {

        System.out.printf("Sum = %d", sum);
        System.out.println();

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row)
                    .replaceAll("[\\[\\],]", ""));
        }
    }

    public static int[][] ExportedMatrix(int[][] matrix, int rowIndex, int colIndex) {

        int[][] outputMatrix = new int[3][3];
        int r = 0, c = 0;

        for (int row = rowIndex; row < rowIndex + 3; row++) {
            for (int col = colIndex; col < colIndex + 3; col++) {
                outputMatrix[r][c] = matrix[row][col];
                c++;
            }

            r++;
            c = 0;
        }

        return outputMatrix;
    }

    public static int MatrixSum(int[][] matrix, int rowIndex, int colIndex) {

        int sum = 0;

        for (int row = rowIndex; row < rowIndex + 3; row++) {
            for (int col = colIndex; col < colIndex + 3; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }

    public static int[][] FillMatrix(Scanner scanner, int rows, int cols) {

        int[][] output = new int[rows][cols];

        for (int row = 0; row < output.length; row++) {
            output[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return output;
    }
}
