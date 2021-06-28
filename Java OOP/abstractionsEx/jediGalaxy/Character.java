package abstractionsEx.jediGalaxy;

import java.util.Arrays;

public class Character {

    protected int[] position;
    protected String input;

    public Character(String input) {
        this.input = input;
        this.position = setDimensions(input);
    }

    protected int[] setDimensions(String input) {
        int[] dimensions2d = Arrays.stream(input
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new int[]{dimensions2d[0], dimensions2d[1]};
    }

    public void destroyStars(Arena arena) {
    }

    public void increaseScore(Arena arena) {
    }
}
