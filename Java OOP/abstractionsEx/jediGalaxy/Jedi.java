package abstractionsEx.jediGalaxy;

public class Jedi extends Character {

    public Jedi(String input) {
        super(input);
    }

    public void increaseScore(Arena arena) {
        while (reachesBorder(arena)) {
            if (arena.cellIsInRange(super.position)) {
                arena.jediScore += arena.getCellValue(super.position);
            }
            moveJedi();
        }
    }

    private boolean reachesBorder(Arena arena) {
        return super.position[0] >= 0 && super.position[1] < arena.getArenaDimensions()[1];
    }

    private void moveJedi() {
        this.position[0]--;
        this.position[1]++;
    }
}
