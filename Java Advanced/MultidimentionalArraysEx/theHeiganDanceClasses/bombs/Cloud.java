package MultidimentionalArraysEx.theHeiganDanceClasses.bombs;

public class Cloud extends Bomb {
    private static final int DAMAGE = 3500;
    private static final int IMPACT_TIMER = 2;

    public Cloud(int[] position) {
        super(position, IMPACT_TIMER, DAMAGE);
    }
}
