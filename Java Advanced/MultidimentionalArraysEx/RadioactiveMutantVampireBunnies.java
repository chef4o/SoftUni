package MultidimentionalArraysEx;

import java.util.*;
import java.util.stream.Collectors;

public class RadioactiveMutantVampireBunnies {
    private static final String player = "PLAYER";
    private static final String bunny = "BUNNIES";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] gameZone = arenaGenerator(scanner);
        Map<String, List<int[]>> charactersPositions = extractPositions(gameZone);
        Deque<String> commands = Arrays.stream(scanner.nextLine()
                .split(""))
                .collect(Collectors.toCollection(ArrayDeque::new));

        boolean playerWins = false;
        int[] playerLastPosition = charactersPositions.get(player).get(0);

        while (!playerWins) {
            String command = "";
            if (commands.peek() != null) {
                command = commands.poll();
            }
            playerLastPosition = charactersPositions.get(player).get(0);
            movePLayer(charactersPositions, command, gameZone);
            if (playerIsOut(charactersPositions.get(player).get(0), gameZone)) {
                playerWins = true;
            } else if (!playerIsAlive(gameZone)) {
                playerLastPosition = placeOfDeath(gameZone);
            }
            spreadBunnies(charactersPositions, gameZone);
            if (!playerIsAlive(gameZone)) {
                break;
            }
            charactersPositions = extractPositions(gameZone);
        }
        printOutput(playerWins, playerLastPosition, gameZone);
    }

    public static void printOutput(boolean playerWins, int[] playerLastPosition, String[][] gameZone) {
        StringBuilder output = new StringBuilder();
        output.append(exportMatrix(gameZone))
                .append(System.lineSeparator());
        if (playerWins) {
            output.append("won: ");
        } else {
            output.append("dead: ");
        }
        output.append(Arrays.toString(playerLastPosition)
                .replaceAll("[\\[\\],]", ""));
        System.out.println(output);
    }

    public static String exportMatrix(String[][] gameZone) {
        StringBuilder output = new StringBuilder();
        Arrays.stream(gameZone)
                .forEach(r -> output.append(Arrays.toString(r)
                        .replaceAll("[\\[\\], ]", ""))
                .append(System.lineSeparator()));
        return output.toString().trim();
    }

    public static int[] placeOfDeath(String[][] gameZone) {
        for (int row = 0; row < gameZone.length; row++) {
            for (int col = 0; col < gameZone[row].length; col++) {
                if (gameZone[row][col].equals("D")) {
                    return new int[] {row, col};
                }
            }
        }
        return null;
    }

    public static boolean playerIsAlive(String[][] gameZone) {
        for (String[] row : gameZone) {
            for (String element : row) {
                if (element.equals("P")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void spreadBunnies(Map<String, List<int[]>> charactersPositions, String[][] gameZone) {
        charactersPositions.get(bunny)
                .forEach(b -> {
            if (!gameZone[Math.max(0, b[0] - 1)][b[1]].equals("B")) {
                gameZone[Math.max(0, b[0] - 1)][b[1]] = "B";
            }
            if (!gameZone[Math.min(gameZone.length - 1, b[0] + 1)][b[1]].equals("B")) {
                gameZone[Math.min(gameZone.length - 1, b[0] + 1)][b[1]] = "B";
            }
            if (!gameZone[b[0]][Math.max(0, b[1] - 1)].equals("B")) {
                gameZone[b[0]][Math.max(0, b[1] - 1)] = "B";
            }
            if (!gameZone[b[0]][Math.min(gameZone[0].length - 1, b[1] + 1)].equals("B")) {
                gameZone[b[0]][Math.min(gameZone[0].length - 1, b[1] + 1)] = "B";
            }
        });
    }

    public static void movePLayer(Map<String, List<int[]>> charactersPositions, String command, String[][] gameZone) {
        int playerRow = charactersPositions.get(player).get(0)[0];
        int playerCol = charactersPositions.get(player).get(0)[1];
        charactersPositions.get(player).remove(0);
        gameZone[playerRow][playerCol] = ".";
        switch (command) {
            case "U":
                playerRow--;
                break;
            case "D":
                playerRow++;
                break;
            case "L":
               playerCol--;
               break;
            case "R":
                playerCol++;
                break;
            default:
                break;
        }
        charactersPositions.get(player).add(new int[]{playerRow, playerCol});
        if (!playerIsOut(charactersPositions.get(player).get(0), gameZone)
        && !gameZone[playerRow][playerCol].equals("B")) {
            gameZone[playerRow][playerCol] = "P";
        } else if (!playerIsOut(charactersPositions.get(player).get(0), gameZone)
                && gameZone[playerRow][playerCol].equals("B")) {
            gameZone[playerRow][playerCol] = "D";
        }
    }

    public static boolean playerIsOut (int[] playerPosition, String[][] matrix) {
        int row = playerPosition[0];
        int col = playerPosition[1];
        return row == -1
                || row == matrix.length
                || col == -1
                || col == matrix[0].length;
    }

    public static Map<String, List<int[]>> extractPositions(String[][] matrix) {
        Map<String, List<int[]>> charactersPositions = new HashMap<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                String currentElement = matrix[row][col];
                if (currentElement.equals("B")) {
                    charactersPositions.putIfAbsent(bunny, new ArrayList<>());
                    charactersPositions.get(bunny).add(new int[]{row, col});
                } else if (currentElement.equals("P")) {
                    charactersPositions.putIfAbsent(player, new ArrayList<>());
                    charactersPositions.get(player).add(new int[]{row, col});
                }
            }
        }
        return charactersPositions;
    }

    public static String[][] arenaGenerator(Scanner scanner) {

        String[] matrixDimensions = scanner.nextLine().split("\\s+");
        int matrixRows = Integer.parseInt(matrixDimensions[0]);
        int matrixCols = Integer.parseInt(matrixDimensions[1]);

        String[][] matrix = new String[matrixRows][matrixCols];
        for (int row = 0; row < matrixRows; row++) {
            String currentColValues = scanner.nextLine();
            for (int col = 0; col < currentColValues.length(); col++) {
                matrix[row][col] = String.valueOf(currentColValues.charAt(col));
            }
        }
        return matrix;
    }
}
