package DataTypesAndVarsEx;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialPokePower = Integer.parseInt(scanner.nextLine());
        int distanceFromTarget = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int pokePower = initialPokePower;
        int numberOfPokes = 0;
        while (pokePower >= distanceFromTarget) {

            numberOfPokes++;
            pokePower -= distanceFromTarget;
            if (pokePower == (initialPokePower / 2) && exhaustionFactor != 0) {
            pokePower /= exhaustionFactor;
            }
        }

        System.out.printf("%d%n%d", pokePower, numberOfPokes);
    }
}
