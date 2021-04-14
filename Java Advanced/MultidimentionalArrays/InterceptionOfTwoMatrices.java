package MultidimentionalArrays;

import java.util.Scanner;

public class InterceptionOfTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayRows = Integer.parseInt(scanner.nextLine());
        int arrayColumns = Integer.parseInt(scanner.nextLine());

        String[][] inputOne = LoadDataToMatrix(scanner, arrayRows, arrayColumns);
        String[][] inputTwo = LoadDataToMatrix(scanner, arrayRows, arrayColumns);

        String[][] outputMatrix = new String[arrayRows][arrayColumns];

        for (int row = 0; row < arrayRows; row++) {

            for (int col = 0; col < arrayColumns; col++) {

                if (inputOne[row][col].equals(inputTwo[row][col])) {
                    outputMatrix[row][col] = inputOne[row][col];
                } else {
                    outputMatrix[row][col] = "*";
                }

                System.out.printf("%s ", outputMatrix[row][col]);
            }

            System.out.println();
        }
    }

    private static String[][] LoadDataToMatrix(Scanner scanner, int arrayRows, int arrayColumns) {

        String[][] input = new String[arrayRows][arrayColumns];

        for (int row = 0; row < arrayRows; row++) {

            String[] currentInput = scanner.nextLine().split("\\s+");

            for (int col = 0; col < arrayColumns; col++) {

                input[row][col] = currentInput[col];
            }
        }

        return input;
    }


}
