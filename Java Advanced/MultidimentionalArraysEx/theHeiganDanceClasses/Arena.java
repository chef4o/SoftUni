package MultidimentionalArraysEx.theHeiganDanceClasses;

import MultidimentionalArraysEx.theHeiganDanceClasses.bombs.Bomb;
import MultidimentionalArraysEx.theHeiganDanceClasses.players.Hero;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Arena {
    public static final int SIZE = 15;

    private int[][] arena;
    private Deque<Bomb> bombsArchive;

    public Arena() {
        this.arena = new int[SIZE][SIZE];
        this.bombsArchive = new ArrayDeque<>();
    }

    public String toString(Hero hero) {
        return "Final position: " + Arrays.toString(hero.getPosition())
                                    .replaceAll("[\\[\\]]", "");
    }

    public Deque<Bomb> getBombsArchive() {
        return this.bombsArchive;
    }

    public Bomb checkLastBomb() {
        return this.bombsArchive.peek();
    }

    public void archiveBomb(Bomb bomb) {
        this.bombsArchive.offer(bomb);
    }
}
