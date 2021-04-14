    package MultidimentionalArrays;

    import java.util.Arrays;
    import java.util.Scanner;

    public class SumMatrixElements {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int[][] matrix = LoadDataToMatrix(scanner, ",\\s+");

            int sumElements = 0;

            for (int[] element : matrix) {
                for (int col = 0; col < element.length; col++) {
                    sumElements += element[col];
                }
            }

            System.out.printf("%d\n%d\n%d\n",matrix.length, matrix[0].length, sumElements);
        }

        private static int[][] LoadDataToMatrix(Scanner scanner, String separator) {

            int[] arrayDimensions = Arrays.stream(scanner.nextLine()
                    .split(separator))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int arrayRows = arrayDimensions[0];
            int arrayColumns = arrayDimensions[1];

            int[][] input = new int[arrayRows][arrayColumns];

            for (int row = 0; row < arrayRows; row++) {

                int[] currentInput = Arrays.stream(scanner.nextLine()
                        .split(separator))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                for (int col = 0; col < arrayColumns; col++) {

                    input[row][col] = currentInput[col];
                }
            }

            return input;
        }
    }
