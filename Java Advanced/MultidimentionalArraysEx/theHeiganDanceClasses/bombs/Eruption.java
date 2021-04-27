package MultidimentionalArraysEx.theHeiganDanceClasses.bombs;

public class Eruption extends Bomb {
    private static final int DAMAGE = 6000;
    private static final int IMPACT_TIMER = 1;

    public Eruption(int[] impactPoint) {
        super(impactPoint, IMPACT_TIMER, DAMAGE);
    }

}
