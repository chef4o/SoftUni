package implementations;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char toBeReplaced;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.toBeReplaced = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
        fillCells(this.startRow, this.startCol);
    }

    private void fillCells(int row, int col) {
        if (isOutOfBound(row, col) || this.matrix[row][col] != this.toBeReplaced) {
            return;
        }

        this.matrix[row][col] = this.fillChar;

        fillCells(row + 1, col);
        fillCells(row, col + 1);
        fillCells(row - 1, col);
        fillCells(row, col - 1);
    }

    private boolean isOutOfBound(int row, int col) {
        return row < 0
                || row >= this.matrix.length
                || col < 0
                || col >= this.matrix[row].length;
    }


    public String toOutputString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                output.append(this.matrix[i][j]);
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
