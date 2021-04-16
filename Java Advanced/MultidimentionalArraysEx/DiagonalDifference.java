package MultidimentionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        int leftSum = 0;
        int rightSum = 0;

        for (int row = 0; row < matrixSize; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int row = 0; row < matrixSize; row++) {
            leftSum += matrix[row][row];
        }

        for (int row = matrixSize - 1; row >= 0 ; row--) {
            rightSum += matrix[row][(matrixSize - 1) - row];
        }

        System.out.println(Math.abs(leftSum - rightSum));
    }
}