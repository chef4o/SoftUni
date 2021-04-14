package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrixOneData = readMatrix(scanner);
        int[][] matrixTwoData = readMatrix(scanner);

        System.out.println(
                EqualMatrices(matrixOneData, matrixTwoData)
                ? "equal"
                : "not equal");
    }

    private static int[][] readMatrix(Scanner scanner) {

        int[] matrixSize = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrixData = new int[matrixSize[0]][matrixSize[1]];

        for (int i = 0; i < matrixSize[0]; i++) {

            int[] row = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrixData[i] = row;
        }

        return matrixData;
    }

    private static boolean EqualMatrices(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
