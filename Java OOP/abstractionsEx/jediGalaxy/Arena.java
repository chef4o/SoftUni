package abstractionsEx.jediGalaxy;

import java.util.Arrays;

public class Arena {
    private int[] arenaDimensions;
    private int[][] arena;
    public long jediScore;

    public Arena(String input) {
        this.arenaDimensions = arenaBorders(input);
        generateArena();
    }

    public int getCellValue(int[] position) {
        return this.arena[position[0]][position[1]];
    }

    public int[] getArenaDimensions() {
        return this.arenaDimensions;
    }

    private void generateArena() {
        int rows = arenaDimensions[0];
        int cols = arenaDimensions[1];
        this.arena = new int[rows][cols];
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.arena[row][col] = value++;
            }
        }
    }

    private int[] arenaBorders(String input) {
        int[] dimensions2d = Arrays.stream(input
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new int[]{dimensions2d[0], dimensions2d[1]};
    }

    public void setCellToZero(int[] position) {
        this.arena[position[0]][position[1]] = 0;
    }

    public boolean cellIsInRange(int[] position) {
        return position[0] >= 0
                && position[0] < this.arena.length
                && position[1] >= 0
                && position[1] < this.arena[0].length;
    }
}
