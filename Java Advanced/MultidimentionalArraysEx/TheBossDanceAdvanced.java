package MultidimentionalArraysEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheBossDanceAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] arena = GenerateArena(15);

        //Arena Legend//
        int          emptyCell       = 0 ;
        int          poisonCloud     = 2 ;
        int          eruption        = 4 ;
        int          player          = 6 ;

        //Game settings//
        String bossName              = "Heigan";
        String playerName            = "Player";
        int          arenaSize       = 15;
        int          eruptionDamage  = 6000 ;
        int          poisonDamage    = 3500 ;
        double       playerDamage    = Double.parseDouble(scanner.nextLine());

        //Gameplay variables//
        String[]     bossAttack      = new String[3] ;
        double       bossHealth      = 3000000 ;
        int          playerHealth    = 18500 ;
        int          poisonStack     = 0 ;

        //Arena actionPoints//
        List<String> bombArea             ;
        int[]        bombPosition         ;
        int[]        playerStartPosition  = new int[] {7, 7};
        int[]        playerNewPosition    ;
        char         playerLocation       ;

        while (bossHealth > 0 && playerHealth > 0) {

            bossAttack = scanner.nextLine().split("\\s+");
            bombPosition = new int[] {Integer.parseInt(bossAttack[1]),
                    Integer.parseInt(bossAttack[2])};
            bombArea = BombArea(bombPosition);

            bossHealth -= playerDamage;

            if (poisonStack > 0) {
                playerHealth -= poisonDamage;
                poisonStack--;
            }

            if (bossHealth <= 0 || playerHealth <= 0) {
                break;
            }

            playerLocation = PlayerLocation(playerStartPosition, bombPosition, bombArea);
            playerNewPosition = PlayerNewPosition(playerStartPosition, playerLocation, bombArea, arenaSize);

            if (playerStartPosition == playerNewPosition) {

                switch (bossAttack[0]) {

                    case "Cloud":
                        poisonStack   = 2;
                        playerHealth -= poisonDamage;
                        poisonStack--;
                        break;

                    case "Eruption":
                        playerHealth -= eruptionDamage;
                        break;
                }
            } else {

                playerStartPosition = playerNewPosition;
            }
        }

        //Game over screen:
        PrintGameOverScreen(bossName, bossHealth, bossAttack[0],
                playerName, playerHealth, playerStartPosition);

    }

    public static void PrintGameOverScreen(String bossName, double bossHealth, String bossAttack,
                                           String playerName, int playerHealth, int[] playerPosition) {

        if (bossAttack.equals("Cloud")) {
            bossAttack = "Plague Cloud";
        }

        String outputFirstRow = bossHealth > 0f
                ? String.format("%s: %.2f\n",         bossName, bossHealth)
                : String.format("%s: Defeated!\n",    bossName);
        String outputSecondRow = playerHealth > 0
                ? String.format("%s: %d\n",           playerName, playerHealth)
                : String.format("%s: Killed by %s\n", playerName, bossAttack);
        String outputThirdRow = String.format("Final position: %s\n",
                Arrays.toString(playerPosition)
                        .replaceAll("[\\[\\]]", ""));

        System.out.println(outputFirstRow
                + outputSecondRow
                + outputThirdRow);
    }

    public static int[] PlayerNewPosition(int[] playerPosition, char playerLocation, List<String> bombArea, int arenaSize) {

        if (playerLocation == '+' || playerLocation == 'x') {
            return playerPosition;
        }

        //Move Priority [DESCENDING]//
        // UP     ▲
        // RIGHT  ▶
        // DOWN   ▼
        // LEFT   ◀

        String stepUp = String.format("%s%s", playerPosition[0] - 1, playerPosition[1]);
        if (!bombArea.contains(stepUp) && MovementIsInArea(playerPosition, arenaSize)) {
            return new int[]{playerPosition[0] - 1, playerPosition[1]};
        }

        String stepRight = String.format("%s%s", playerPosition[0], playerPosition[1] + 1);
        if (!bombArea.contains(stepRight) &&
                MovementIsInArea(playerPosition, arenaSize)) {

            return new int[]{playerPosition[0], playerPosition[1] + 1};
        }

        String stepDown = String.format("%s%s", playerPosition[0] + 1, playerPosition[1]);
        if (!bombArea.contains(stepDown) &&
                MovementIsInArea(playerPosition, arenaSize)) {

            return new int[]{playerPosition[0] + 1, playerPosition[1]};
        }

        String stepLeft = String.format("%s%s", playerPosition[0], playerPosition[1] - 1);
        if (!bombArea.contains(stepLeft) &&
                MovementIsInArea(playerPosition, arenaSize)) {

            return new int[]{playerPosition[0], playerPosition[1] - 1};
        }

        return playerPosition;
    }

    public static boolean MovementIsInArea(int[] playerPosition, int arenaSize) {

        return  playerPosition[1] - 1 >= 0          &&
                playerPosition[1] + 1 <  arenaSize  &&
                playerPosition[0] - 1 >= 0          &&
                playerPosition[0] + 1 <  arenaSize;
    }

    public static char PlayerLocation (int[] playerPosition, int[]bombPosition, List<String> bombArea) {

        //Legend of impact:
        // + -> inCenterOfImpact
        // o -> onEdgeOfImpact
        // x -> notInRange (default)

        String playerCell = String.format("%s%s", playerPosition[0], playerPosition[1]);
        String bombCenter = String.format("%s%s", bombPosition[0], bombPosition[1]);

        if (playerCell.equals(bombCenter)) {
            return '+';
        }

        if (bombArea.contains(playerCell)) {
            return 'o';
        }

        return 'x';
    }

    public static List<String> BombArea(int[] bombPosition) {

        List<String> bombArea = new ArrayList<>();

        for (int row = bombPosition[0] - 1; row <= bombPosition[0] + 1; row++) {

            for (int col = bombPosition[1] - 1; col <= bombPosition[1] + 1; col++) {

                bombArea.add(String.format("%s%s", row, col));
            }
        }

        return bombArea;
    }

    public static int[][] GenerateArena(int squareArenaSize) {

        int [][] arena       = new int[squareArenaSize][squareArenaSize];
        int arenaCenterIndex = squareArenaSize / 2;

        for (int row = 0; row < squareArenaSize; row++) {
            for (int col = 0; col < squareArenaSize; col++) {

                if (row == arenaCenterIndex && col == arenaCenterIndex) {

                    arena[row][col] = 6;    // Placing the player in the center of the map
                } else {

                    arena[row][col] = 0;    // Filling the arena with clean cells
                }
            }
        }

        return arena;
    }
}
