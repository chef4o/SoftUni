package Task2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        Deque<String> moves = Arrays.stream(scanner.nextLine()
                .split(","))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[fieldSize][fieldSize];
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("\\s+");
        }

        int numberOfBombs = countBombs(field);
        int[] position = findStartingPosition(field);

        while (!moves.isEmpty()) {
            position = newPosition(field, position, moves.poll());

            if (bombIsLocated(field, position)) {
                numberOfBombs--;
                output.append("You found a bomb!");
                output.append(System.lineSeparator());
                if (numberOfBombs == 0) {
                    output.append("Congratulations! You found all bombs!");
                    output.append(System.lineSeparator());
                    break;
                }
            } else if (exitIsLocated(field, position)) {
                output.append(String.format("END! %d bombs left on the field", numberOfBombs));
                output.append(System.lineSeparator());
                System.out.printf("END! %d bombs left on the field\n", numberOfBombs);
                break;
            }
        }

        if (numberOfBombs > 0 && !moves.isEmpty()) {
            output.append(String.format("%d bombs left on the field. Sapper position: (%s)\n",
                    numberOfBombs, Arrays.toString(position).replaceAll("[\\[\\] ]", "")));
            output.append(System.lineSeparator());
        }

        System.out.println(output);
    }

    public static boolean bombIsLocated (String[][] field, int[] position) {
        return field[position[0]][position[1]].equals("B");
    }

    public static boolean exitIsLocated (String[][] field, int[] position) {
        return field[position[0]][position[1]].equals("e");
    }

    public static int[] newPosition(String[][] field, int[] position, String direction) {

        int[] updatedPosition = null;

        switch (direction) {
            case "up":
                if (isInBounds(field, position)
                        && position[0] - 1 >= 0) {
                    updatedPosition = new int[]{position[0] - 1, position[1]};
                }
                break;
            case "down":
                if (isInBounds(field, position)
                        && position[0] + 1 < field.length) {
                    updatedPosition = new int[]{position[0] + 1, position[1]};
                }
                break;
            case "left":
                if (isInBounds(field, position)
                        && position[1] - 1 >= 0) {
                    updatedPosition = new int[]{position[0], position[1] - 1};
                }
                break;
            case "right":
                if (isInBounds(field, position)
                        && position[1] + 1 < field[position[0]].length) {
                    updatedPosition = new int[]{position[0], position[1] + 1};
                }
                break;
        }

        if (updatedPosition == null) {
            updatedPosition = position;
        }

        return updatedPosition;
    }

    public static boolean isInBounds(String[][] field, int[] position) {
        return (position[0] >= 0 && position[0] < field.length
                && position[1] >= 0 && position[1] < field[position[0]].length);
    }

    public static int[] findStartingPosition (String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("s")) {
                    return new int[] {row, col};
                }
            }
        }
        return null;
    }

    public static int countBombs (String[][] field) {
        int counter = 0;
        for (String[] row : field) {
            for (String cell : row) {
                if (cell.equals("B")) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
