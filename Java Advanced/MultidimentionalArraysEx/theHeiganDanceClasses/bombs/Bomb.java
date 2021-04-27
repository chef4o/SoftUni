package MultidimentionalArraysEx.theHeiganDanceClasses.bombs;

import MultidimentionalArraysEx.theHeiganDanceClasses.Arena;

import java.util.ArrayList;
import java.util.List;

public class Bomb {
    protected int timer;
    protected int damage;
    private int[] impactPosition;
    private List<int[]> impactArea;

    public Bomb(int[] position, int time, int damage) {
        this.setPosition(position);
        this.impactArea = setImpactArea();
        this.setTimer(time);
        this.setDamage(damage);
    }

    public int getTimer() {
        return timer;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    public void setTimer(int time) {
        this.timer = time;
    }

    public List<int[]> getImpactArea() {
        return this.impactArea;
    }

    private void setPosition(int[] position) {
        this.impactPosition = position;
    }

    private List<int[]> setImpactArea() {
        List<int[]> impactArea = new ArrayList<>();
        int startRow = Math.max(0, this.impactPosition[0] - 1);
        int endRow = Math.min(Arena.SIZE, this.impactPosition[0] + 1);
        int startCol = Math.max(0, this.impactPosition[1] - 1);;
        int endCol= Math.min(Arena.SIZE, this.impactPosition[1] + 1);
        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                impactArea.add(new int[]{row, col});
            }
        }
        return impactArea;
    }

    public boolean canExplode() {
        return this.timer > 0;
    }

    public double explode() {
        this.timer -= 1;
        return this.timer >= 0 ? this.damage : 0;
    }
}
