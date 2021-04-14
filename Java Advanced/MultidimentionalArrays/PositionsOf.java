package MultidimentionalArrays;

import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[scanner.nextInt()][scanner.nextInt()];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int searchNum = scanner.nextInt();

        boolean hasMatches  = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == searchNum) {
                    System.out.printf("%d %d\n", row, col);
                    hasMatches = true;
                }
            }
        }

        if (!hasMatches) {
            System.out.println("not found");
        }
    }
}