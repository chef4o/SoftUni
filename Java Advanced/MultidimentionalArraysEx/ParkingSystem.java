package MultidimentionalArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        boolean[][] parking = new boolean[rows][cols];

        while (true) {
            String input = reader.readLine();
            if (input.equals("stop")) break;
            String[] command = input.split("\\s+");

            int z = Integer.parseInt(command[0]);
            int x = Integer.parseInt(command[1]);
            int y = Integer.parseInt(command[2]);

            int moves = 0;
            boolean found = false;

            if (!parking[x][y]) {
                moves = findMoves(z, x, y);
                parking[x][y] = true;
                found = true;
            } else {
                int range = 1;
                while (!found) {
                    if (y - range >= 1 && !parking[x][y - range]) {
                        moves = findMoves(z, x, y - range);
                        found = true;
                        parking[x][y - range] = true;
                    } else if (y + range < parking[x].length && !parking[x][y + range]) {
                        moves = findMoves(z, x, y + range);
                        found = true;
                        parking[x][y + range] = true;
                    }
                    if (y - range < 1 && y + range >= parking[x].length) {
                        System.out.printf("Row %d full\n", x);
                        break;
                    }
                    range++;
                }
            }
            if (found) System.out.println(moves);
        }
    }

    private static int findMoves(int z, int x, int y) {
        return Math.abs(z - x) + y + 1;
    }
}