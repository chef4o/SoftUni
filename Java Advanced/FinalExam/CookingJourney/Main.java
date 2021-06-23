package CookingJourney;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int shopSize = Integer.parseInt(scanner.nextLine());
        String[][] shopArena = squareArena(shopSize, scanner);
        int[] startPosition = findStartingPosition(shopArena);
        List<int[]> portalsPositions = findPorts(shopArena);
        int collectedMoney = 0;

        int[] currentPosition = startPosition;
        while (currentPosition != null
                && isInShop(currentPosition, shopArena)
                && collectedMoney < 50) {

            String direction = scanner.nextLine();

            shopArena[currentPosition[0]][currentPosition[1]] = "-";
            currentPosition = move(currentPosition, direction);

            if (isInShop(currentPosition, shopArena)) {
                if (shopArena[currentPosition[0]][currentPosition[1]].equals("P")) {
                    shopArena[currentPosition[0]][currentPosition[1]] = "-";
                    currentPosition = portalsPositions.get(teleportIndex(portalsPositions, currentPosition));
                } else if (shopArena[currentPosition[0]][currentPosition[1]].matches("\\d")) {
                    collectedMoney += Integer.parseInt(shopArena[currentPosition[0]][currentPosition[1]]);
                }
            } else {
                break;
            }

            shopArena[currentPosition[0]][currentPosition[1]] = "S";
        }

        if (collectedMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.println("Money: " + collectedMoney);
        for (String[] row : shopArena) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\], ]", ""));
        }
    }

    public static int[] move(int[] position, String direction) {

        int[] updatedPosition = position;

        switch (direction) {
            case "up":
                updatedPosition = new int[]{position[0] - 1, position[1]};
                break;
            case "down":
                updatedPosition = new int[]{position[0] + 1, position[1]};
                break;
            case "left":
                updatedPosition = new int[]{position[0], position[1] - 1};
                break;
            case "right":
                updatedPosition = new int[]{position[0], position[1] + 1};
                break;
        }

        return updatedPosition;
    }


    public static String[][] squareArena(int size, Scanner scanner) {
        String[][] output = new String[size][size];
        for (int row = 0; row < size; row++) {
            output[row] = scanner.nextLine().split("");
        }
        return output;
    }

    public static int[] findStartingPosition(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("S")) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    public static List<int[]> findPorts(String[][] field) {
        List<int[]> portsPositions = new ArrayList<>();
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("P")) {
                    portsPositions.add(new int[]{row, col});
                }
            }
        }
        return portsPositions;
    }

    public static boolean isInShop(int[] clientPosition, String[][] field) {
        return (clientPosition[0] >= 0 && clientPosition[0] < field.length
                && clientPosition[1] >= 0 && clientPosition[1] < field[clientPosition[0]].length);
    }

    public static int teleportIndex(List<int[]> portalsPositions, int[] position) {

        int xPosition = portalsPositions.get(0)[0];
        int yPosition = portalsPositions.get(0)[1];

        if (xPosition == position[0] && yPosition == position[1]) {
            return 1;
        }
        return 0;
    }
}
