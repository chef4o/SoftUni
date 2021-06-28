package abstractionsEx.jediGalaxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arena arena = new Arena(scanner.nextLine());

        String input;
        while (!(input = scanner.nextLine()).equals("Let the Force be with you")) {

            Character jedi = new Jedi(input);
            Character evil = new Evil(scanner.nextLine());
            evil.destroyStars(arena);
            jedi.increaseScore(arena);
        }

        System.out.println(arena.jediScore);
    }
}
