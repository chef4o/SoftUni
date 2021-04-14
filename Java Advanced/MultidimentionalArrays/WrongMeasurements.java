package MultidimentionalArrays;

import java.util.*;

public class WrongMeasurements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][];
        List<List<Integer>> output = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = LoadMatrix(scanner);
        }

        int colSize = matrix[1].length;

        int[] wrongNumberPosition = LoadMatrix(scanner);
        int wrongNumber = matrix[wrongNumberPosition[0]][wrongNumberPosition[1]];

        for (int row = 0; row < matrix.length; row++) {

            List<Integer> rowOutput = new ArrayList<>();
            for (int col = 0; col < matrix[row].length; col++) {

                int currentNum = matrix[row][col];
                int[] currentNumPosition = new int[] {row, col};

                if (currentNum == wrongNumber) {
                    rowOutput.add(SurroundingSum(currentNumPosition, matrix, colSize, wrongNumber));
                } else {
                    rowOutput.add(currentNum);
                }
            }

            output.add(rowOutput);
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println(Arrays.toString(output.get(i).toArray())
                    .replaceAll("[\\[\\],]", ""));
        }
    }

    public static int[] LoadMatrix (Scanner scanner) {

        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int SurroundingSum (int[] position, int[][] matrix, int colSize, int wrongNumber) {

        int numberRow = position[0];
        int numberCol = position[1];

        int leftIndex =  numberCol - 1;
        int upperIndex = numberRow - 1;
        int rightIndex = numberCol + 1;
        int lowerIndex = numberRow + 1;

        int sum = 0;

        if (leftIndex >= 0 && matrix[numberRow][leftIndex] != wrongNumber) {
            sum += matrix[numberRow][leftIndex];
        }
        if (rightIndex < colSize && matrix[numberRow][rightIndex] != wrongNumber) {
            sum += matrix[numberRow][rightIndex];
        }
        if (upperIndex >= 0 && matrix[upperIndex][numberCol] != wrongNumber) {
            sum += matrix[upperIndex][numberCol];
        }
        if (lowerIndex < matrix.length && matrix[lowerIndex][numberCol] != wrongNumber) {
            sum += matrix[lowerIndex][numberCol];
        }

        return sum;
    }
}
