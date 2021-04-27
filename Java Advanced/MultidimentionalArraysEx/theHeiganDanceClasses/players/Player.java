package MultidimentionalArraysEx.theHeiganDanceClasses.players;

public abstract class Player {

    private double health;

    public Player(double health) {
        this.setHealth(health);
    }

    public double getHealth() {
        return this.health;
    }

    private void setHealth(double health) {
        this.health = health;
    }

    protected void reduceHealth(double damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public abstract void hit(Player opponent);
}
