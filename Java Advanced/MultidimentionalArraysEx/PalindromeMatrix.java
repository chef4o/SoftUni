package MultidimentionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextByte();
        int cols = scanner.nextByte();

        String[][] matrix = new String[rows][cols];

        StringBuilder cell;

        char r = 97;

        for (int row = 0; row < rows; row++) {

            char c = r;

            for (int col = 0; col < cols; col++) {

            cell = new StringBuilder();
            cell.append(r);
            cell.append(c);
            cell.append(r);

            matrix[row][col] = cell.toString();
            c++;
            }

            r++;
        }

        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row)
                    .replaceAll("[\\[\\],]", ""));
        }
    }
}
