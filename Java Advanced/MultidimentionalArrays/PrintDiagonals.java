package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int row = 0, col = 0;

        while (row < matrixSize && col < matrixSize) {

            System.out.print(matrix[row++][col++] + " ");
        }
        System.out.println();

        row = matrixSize - 1;
        col = 0;

        while (row >= 0 && col < matrixSize) {
            System.out.print(matrix[row--][col++] + " ");
        }
    }
}
