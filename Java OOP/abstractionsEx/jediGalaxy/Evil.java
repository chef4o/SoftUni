package abstractionsEx.jediGalaxy;

public class Evil extends Character {

    public Evil(String input) {
        super(input);
    }

    public void destroyStars(Arena arena) {
        while (reachesBorder()) {
            if (arena.cellIsInRange(super.position)) {
                arena.setCellToZero(super.position);
            }
            moveEvil();
        }
    }

    private boolean reachesBorder() {
        return super.position[0] >= 0 && super.position[1] >= 0;
    }

    private void moveEvil() {
        super.position[0]--;
        super.position[1]--;
    }
}
