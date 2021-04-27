package MultidimentionalArraysEx.theHeiganDanceClasses.players;

import MultidimentionalArraysEx.theHeiganDanceClasses.Arena;
import MultidimentionalArraysEx.theHeiganDanceClasses.bombs.Bomb;

public class Hero extends Player {
    private static final int TOTAL_HEALTH = 18500;

    private double attackDamage;
    private int[] position;

    public Hero(String damage, int[] position) {
        super(TOTAL_HEALTH);
        this.setAttackDamage(damage);
        this.setPosition(position);
    }

    public int[] getPosition() {
        return this.position;
    }

    private void setAttackDamage(String attackDamage) {
        this.attackDamage = Double.parseDouble(attackDamage);
    }

    private void setPosition(int[] position) {
        this.position = new int[]{position[0], position[1]};
    }

    public void run(int[] newPosition) {
        this.position = newPosition;
    }

    @Override
    public void hit(Player opponent) {
        opponent.reduceHealth(this.attackDamage);
    }

    public int[] stepUp() {
        return new int[]{
                Math.max(0, this.position[0] - 1),
                this.position[1]};
    }

    public int[] stepDown() {
        return new int[]{Math.min(
                Arena.SIZE, this.position[0] + 1),
                this.position[1]};
    }

    public int[] stepRight() {
        return new int[]{
                this.position[0],
                Math.min(Arena.SIZE, this.position[1] + 1)};
    }

    public int[] stepLeft() {
        return new int[]{
                this.position[0],
                Math.max(0, this.position[1] - 1)};
    }

    private boolean positionsMatch (int[] bombPosition, int[] heroPosition) {
        return bombPosition[0] == heroPosition[0] && bombPosition[1] == heroPosition[1];
    }

    private int[] blockedPositions(Bomb bomb, int[] heroMovement) {
        return bomb.getImpactArea()
                .stream()
                .filter(b -> positionsMatch(b, heroMovement))
                .findFirst()
                .orElse(null);
    }

    public int[] movement(Bomb bomb) {
        if (this.blockedPositions(bomb, this.position) == null) {
            return this.position;
        }
        if (this.blockedPositions(bomb, this.stepUp()) == null) {
            return this.stepUp();
        }
        if (this.blockedPositions(bomb, this.stepRight()) == null) {
            return this.stepRight();
        }
        if (this.blockedPositions(bomb, this.stepDown()) == null) {
            return this.stepDown();
        }
        if (this.blockedPositions(bomb, this.stepLeft()) == null) {
            return this.stepLeft();
        }
        return null;
    }

    public String toString(Bomb bomb) {
        return this.isAlive()
                ? "Player: " + super.getHealth()
                : "Player: Killed by " + (bomb.getClass().getSimpleName().equals("Cloud")
                                            ? "Plague Cloud"
                                            : bomb.getClass().getSimpleName());
    }
}
