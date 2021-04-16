package MultidimentionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = LoadArray(scanner);
        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = LoadArray(scanner);
        }

        for (int row = matrix.length - 1;  row >= 0; row--) {

            for (int col = matrix[row].length - 1; col >= 0; col--) {

                StringBuilder output = new StringBuilder();

                if (row <  matrix.length - 1) {
                    col = 0;
                }

                output.append(matrix[row][col]);
                output.append(" ");

                int newRow = row;
                int newCol = col;

                while (--newRow >= 0 && ++newCol < matrix[row].length) {
                    output.append(matrix[newRow][newCol]);
                    output.append(" ");
                }

                System.out.println(output);
            }
        }
    }

    public static int[] LoadArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}