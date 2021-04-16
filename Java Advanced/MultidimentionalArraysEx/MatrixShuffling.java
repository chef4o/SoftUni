package MultidimentionalArraysEx;

import java.util.*;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = InputStream(scanner, 0);

        int matrixRows = matrixDimensions[0];
        int matrixCols = matrixDimensions[1];

        String[][] matrix = new String[matrixRows][];

        for (int row = 0; row < matrixRows; row++) {
            matrix[row] = InputStream(scanner, "");
        }

        String command;
        while (!"End".equals(command = scanner.nextLine())) {

            if (!CommandIsValid(command, matrixRows, matrixCols)) {
                System.out.println("Invalid input!");
                continue;
            }

            if (command.equals("END")) {
                break;
            }

            String[] indexes = command.split("\\s+");

            IndexSwap(matrix, indexes);
            Print(matrix);
        }
    }

    public static String[][] IndexSwap (String[][] matrix, String[] indexes) {

        int rowOne = Integer.parseInt(indexes[1]);
        int colOne = Integer.parseInt(indexes[2]);
        int rowTwo = Integer.parseInt(indexes[3]);
        int colTwo = Integer.parseInt(indexes[4]);

        String newIndexValue = matrix[rowTwo][colTwo];

        matrix[rowTwo][colTwo] = matrix[rowOne][colOne];
        matrix[rowOne][colOne] = newIndexValue;

        return matrix;
    }

    public static String[] InputStream (Scanner scanner, String letter) {

        return scanner.nextLine().split("\\s+");
    }

    public static int[] InputStream (Scanner scanner, int digit) {

        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static boolean CommandIsValid (String input, int matrixRows, int matrixCols) {

        if (input.equals("END")) {
            return true;
        }

        String[] instructions = input.split("\\s+");

        String command = instructions[0];
        if (!command.equals("swap") || instructions.length != 5) {
            return false;
        }

        int rowOne = Integer.parseInt(instructions[1]);
        int colOne = Integer.parseInt(instructions[2]);
        int rowTwo = Integer.parseInt(instructions[3]);
        int colTwo = Integer.parseInt(instructions[4]);

        if (rowOne >= matrixRows
        || rowTwo >= matrixRows
        || colOne >= matrixCols
        || colTwo >= matrixCols) {
            return false;
        }

        return true;
    }

    public static void Print(String[][] matrix) {

        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row)
                    .replaceAll("[\\[\\],]", ""));
        }
    }
}
