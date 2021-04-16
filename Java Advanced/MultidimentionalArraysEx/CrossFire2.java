package MultidimentionalArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrossFire2 {

    public static void main(String[] args) throws IOException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        int[] warZoneSize = Arrays.stream(scanner.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = warZoneSize[0];
        int cols = warZoneSize[1];

        List<List<Integer>> surviveZone = new ArrayList<>();

        int counter = 1;

        for (int row = 0; row < rows; row++) {
            surviveZone.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                surviveZone.get(row).add(counter++);
            }
        }

        String beam = scanner.readLine();

        while (!beam.equals("Nuke it from orbit")) {
            String[] impactPoint = beam.split(" ");

            int row = Integer.parseInt(impactPoint[0]);
            int col = Integer.parseInt(impactPoint[1]);
            int radius = Integer.parseInt(impactPoint[2]);

            for (int i = row - radius; i <= row + radius; i++) {

                if (ZoneIsInRange(i, col, surviveZone) && i != row) {
                    surviveZone.get(i).remove(col);
                }
            }

            for (int j = col + radius; j >= col - radius ; j--) {

                if (ZoneIsInRange(row, j, surviveZone)) {
                    surviveZone.get(row).remove(j);
                }
            }

            surviveZone.removeIf(List::isEmpty);
            beam = scanner.readLine();

        }

        for (List<Integer> cells : surviveZone) {

            for (Integer cell : cells) {

                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }

    private static boolean ZoneIsInRange(int row, int col, List<List<Integer>> matrix) {

        return row >= 0 &&
                row < matrix.size() &&
                col >= 0 &&
                col < matrix.get(row).size();
    }
}
