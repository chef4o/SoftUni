package MultidimentionalArrays;

import java.util.Scanner;

public class FindTheQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessBoard = new String[8][8];

        for (int row = 0; row < chessBoard.length; row++) {
            chessBoard[row] = scanner.nextLine().split("\\s+");
        }

        boolean queenFount = false;

        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard.length; col++) {

                String figure = chessBoard[row][col];
                int[] position = new int[] {row, col};

                if (RealQueen(figure, chessBoard, position)) {
                    System.out.printf("%d %d", row, col);
                    queenFount = true;
                    break;
                }
            }

            if (queenFount) {
                break;
            }
        }

    }

    public static boolean RealQueen (String figure, String[][] chessBoard, int[] position) {

        // upper left diagonal
        int row = position[0] - 1;
        int col = position[1] - 1;

        while (row >= 0 && col >= 0) {
            if (chessBoard[row--][col--].equals(figure)) {
                return false;
            }
        }

        // upper right diagonal
        row = position[0] - 1;
        col = position[1] + 1;

        while (row >= 0 && col < chessBoard.length) {
            if (chessBoard[row--][col++].equals(figure)) {
                return false;
            }
        }

        //lower left diagonal

        row = position[0] + 1;
        col = position[1] - 1;

        while (row < chessBoard.length && col >= 0) {
            if (chessBoard[row++][col--].equals(figure)) {
                return false;
            }
        }

        //lower right diagonal

        row = position[0] + 1;
        col = position[1] + 1;

        while (row < chessBoard.length && col < chessBoard.length) {
            if (chessBoard[row++][col++].equals(figure)) {
                return false;
            }
        }

        //up

        row = position[0] - 1;
        col = position[1];

        while (row >= 0) {
            if (chessBoard[row--][col].equals(figure)) {
                return false;
            }
        }

        //down

        row = position[0] + 1;
        col = position[1];

        while (row < chessBoard.length) {
            if (chessBoard[row++][col].equals(figure)) {
                return false;
            }
        }

        //left

        row = position[0];
        col = position[1] - 1;

        while (col >= 0) {
            if (chessBoard[row][col--].equals(figure)) {
                return false;
            }
        }

        //right

        row = position[0];
        col = position[1] + 1;

        while (col < chessBoard.length) {
            if (chessBoard[row][col++].equals(figure)) {
                return false;
            }
        }

        return true;
    }
}
