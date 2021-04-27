package MultidimentionalArraysEx.theHeiganDanceClasses.players;

import MultidimentionalArraysEx.theHeiganDanceClasses.bombs.Bomb;

public class Boss extends Player {
    private static final int TOTAL_HEALTH = 3000000;

    private Bomb bomb;

    public Boss() {
        super(TOTAL_HEALTH);
    }

    private Bomb getBomb() {
        return this.bomb;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }

    @Override
    public void hit(Player opponent) {
        Bomb currentBomb = getBomb();
        if (currentBomb != null) {
            opponent.reduceHealth(currentBomb.explode());
        }
    }

    @Override
    public String toString() {
        return this.isAlive()
                ? "Heigan: " + String.format("%.2f", super.getHealth())
                : "Heigan: Defeated!";
    }
}
