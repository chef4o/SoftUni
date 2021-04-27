package MultidimentionalArraysEx.theHeiganDanceClasses;

import MultidimentionalArraysEx.theHeiganDanceClasses.bombs.Bomb;
import MultidimentionalArraysEx.theHeiganDanceClasses.bombs.Cloud;
import MultidimentionalArraysEx.theHeiganDanceClasses.bombs.Eruption;
import MultidimentionalArraysEx.theHeiganDanceClasses.players.Boss;
import MultidimentionalArraysEx.theHeiganDanceClasses.players.Hero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arena bossZone = new Arena();
        int[] heroStartPosition = new int[]{7, 7};
        Hero hero = new Hero(scanner.nextLine(), heroStartPosition);
        Boss boss = new Boss();
        Bomb currentBomb = takeBomb(scanner.nextLine());
        boss.setBomb(currentBomb);

        while (hero.isAlive() || boss.isAlive()) {

            hero.hit(boss);
            if (!boss.isAlive()) {
                break;
            }

            if (!bossZone.getBombsArchive().isEmpty()
                    && bossZone.checkLastBomb().getClass().getSimpleName().equals("Cloud")
                    && bossZone.checkLastBomb().getTimer() == 1) {
                boss.hit(hero);
            }

            if (!hero.isAlive()) {
                break;
            }

            int[] heroNewPosition = hero.movement(currentBomb);

            if (heroNewPosition != null) {
                hero.run(heroNewPosition);
            } else {
                boss.hit(hero);
            }

            bossZone.archiveBomb(currentBomb);
            currentBomb = takeBomb(scanner.nextLine());
            boss.setBomb(currentBomb);
        }

        System.out.println(boss.toString());
        System.out.println(hero.toString(currentBomb));
        System.out.println(bossZone.toString(hero));
    }

    public static Bomb takeBomb(String input) {
        String[] bombDetails = input.split("\\s+");
        String bombType = bombDetails[0];
        int[] bombPosition = new int[]{
                Integer.parseInt(bombDetails[1]),
                Integer.parseInt(bombDetails[2])};
        switch (bombType) {
            case "Cloud":
                return new Cloud(bombPosition);
            case "Eruption":
                return new Eruption(bombPosition);
            default:
                return null;
        }
    }
}
