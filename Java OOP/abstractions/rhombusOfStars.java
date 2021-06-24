package abstractions;

import java.util.Scanner;

public class rhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rhombusSize = Integer.parseInt(scanner.nextLine());

        for (int stars = 1; stars <= rhombusSize; stars++) {
            printRow(rhombusSize, stars);
        }
        for (int stars = rhombusSize - 1; stars >= 1; stars--) {
            printRow(rhombusSize, stars);
        }
    }

    static void printRow (int rhombusSize, int numberOfStars) {
        System.out.println(rowGenerator(rhombusSize, numberOfStars));
    }

    static String rowGenerator(int rhombusSize, int numberOfStars) {

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < rhombusSize - numberOfStars; i++)
            output.append(" ");
        for (int j = 1; j <= numberOfStars; j++) {
            output.append("* ");
        }
        return output.toString();
    }
}
