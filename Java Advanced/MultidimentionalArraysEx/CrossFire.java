package MultidimentionalArraysEx;

import java.io.IOException;
import java.util.*;

public class CrossFire {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int[] warZoneSize = LoadArray(scanner, "\\s+");
        int matrixRows = warZoneSize[0];
        int matrixCols = warZoneSize[1];

        List<List<Integer>> survivalZone = CreateMatrix(matrixRows, matrixCols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {

            int[] bombImpact = LoadArray(command, "\\s+");

            UpdateSurvivalZone(survivalZone, bombImpact);

            command = scanner.nextLine();
        }

        Print(survivalZone);
    }

    public static void Print(List<List<Integer>> matrix) {

        for (List<Integer> row : matrix) {

            System.out.println(row.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    public static void UpdateSurvivalZone(List<List<Integer>> matrix, int[] bombImpact) {

        int yCoordinates = bombImpact[0];
        int xCoordinates = bombImpact[1];
        int radiusOfImpact = bombImpact[2];

        int impactedRowIndexesStart = xCoordinates - radiusOfImpact;
        int impactedRowIndexesEnd = xCoordinates + radiusOfImpact;
        int impactedColIndexesStart = yCoordinates - radiusOfImpact;
        int impactedColIndexesEnd = yCoordinates + radiusOfImpact;

        for (int row = 0; row < matrix.size(); row++) {

            List<Integer> currentRow = matrix.get(row);

            if (row == yCoordinates
                    && impactedRowIndexesStart < currentRow.size()
                    && impactedRowIndexesEnd >= 0) {

                int startIndex = Math.max(impactedRowIndexesStart, 0);
                int endIndex = Math.min(impactedRowIndexesEnd, currentRow.size() - 1);

                currentRow.subList(startIndex, endIndex + 1).clear();

            } else if ((xCoordinates >= 0 && xCoordinates < currentRow.size())
                    && impactedColIndexesStart < matrix.size()
                    && impactedColIndexesEnd >= 0) {

                if (row >= impactedColIndexesStart && row < impactedColIndexesEnd)
                currentRow.remove(xCoordinates);
            }
        }
    }

    public static List<List<Integer>> CreateMatrix(int rows, int cols) {

        List<List<Integer>> matrix = new ArrayList<>();
        int cell = 1;

        for (int row = 0; row < rows; row++) {

            List<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                currentRow.add(cell++);
            }

            matrix.add(currentRow);
        }

        return matrix;
    }

    public static int[] LoadArray(Scanner scanner, String splitter) {

        return Arrays.stream(scanner.nextLine()
                .split(splitter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[] LoadArray(String string, String splitter) {

        return Arrays.stream(string
                .split(splitter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
