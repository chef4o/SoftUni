package MultidimentionalArraysEx;

import java.util.*;

public class StringMatrixRotations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("[()]");
        int rotationAngle = Integer.parseInt(command[1]) % 360;

        List<String> inputData = new ArrayList<>();
        int matrixRows = 0, maxMatrixCols = 0;

        String input;
        while (!"END".equals(input = scanner.nextLine())) {

            matrixRows++;
            int currentColSize = input.length();
            if (currentColSize > maxMatrixCols) {
                maxMatrixCols = currentColSize;
            }

            inputData.add(input);
        }

        char[][] matrix = CreateMatrix(inputData, matrixRows, maxMatrixCols);

        char[][] output;
        if (rotationAngle == 90) {

            output = RotateMatrixBy90(matrix, rotationAngle);
        } else if (rotationAngle == 180) {

            output = RotateMatrixBy180(matrix, rotationAngle);
        } else if (rotationAngle == 270) {

            output = RotateMatrixBy270(matrix, rotationAngle);
        } else {
            output = matrix;
        }

        Print(output);
    }

    public static char[][] CreateMatrix(List<String> input, int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {

            String r = input.get(row);

            for (int col = 0; col < cols; col++) {
                if (col < r.length()) {
                    matrix[row][col] = r.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        return matrix;
    }

    public static char[][] RotateMatrixBy90(char[][] matrix, int rotationAngle) {

        int originalRows = matrix.length - 1;
        int originalCols = 0;

        int newRows = matrix[0].length;
        int newCols = matrix.length;

        char[][] rotatedMatrix = new char[newRows][newCols];

        for (int row = 0; row < newRows; row++) {
            for (int col = 0; col < newCols; col++) {
                rotatedMatrix[row][col] = matrix[originalRows][originalCols];
                originalRows--;
            }
            originalRows = matrix.length - 1;
            originalCols++;
        }

        return rotatedMatrix;
    }

    public static char[][] RotateMatrixBy180(char[][] matrix, int rotationAngle) {

        int originalRows = matrix.length - 1;
        int originalCols = matrix[0].length - 1;

        char[][] rotatedMatrix = new char[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                rotatedMatrix[row][col] = matrix[originalRows][originalCols];
                originalCols--;
            }

            originalCols = matrix[0].length - 1;
            originalRows--;
        }

        return rotatedMatrix;
    }

    private static char[][] RotateMatrixBy270(char[][] matrix, int rotationAngle) {

        int originalRows = 0;
        int originalCols = matrix[0].length - 1;

        int newRows = matrix[0].length;
        int newCols = matrix.length;

        char[][] rotatedMatrix = new char[newRows][newCols];

        for (int row = 0; row < newRows; row++) {
            for (int col = 0; col < newCols; col++) {
                rotatedMatrix[row][col] = matrix[originalRows][originalCols];
                originalRows++;
            }
            originalRows = 0;
            originalCols--;
        }

        return rotatedMatrix;
    }

    public static void Print(char[][] matrix) {

        for (char[] row : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {

                System.out.print(String.valueOf(row[col]));
            }
            System.out.println();
        }
    }
}
