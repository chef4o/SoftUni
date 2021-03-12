package ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {

    public static void main(String[] args) {

        String[] input = new Scanner(System.in).nextLine().split(" ");

        Random randomize = new Random();

        for (int i = 0; i < input.length; i++) {
            int randomA = randomize.nextInt(input.length);
            int randomB = randomize.nextInt(input.length);

            String oldValue = input[randomA];
            input[randomA] = input[randomB];
            input[randomB] = oldValue;
        }

        System.out.println(String.join("\n", input));
    }
}
