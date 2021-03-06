package Methods;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);

        printRangeOfCharacters(start, end);

    }

    static void printRangeOfCharacters(char a, char b) {

        int startRange = Math.min(a, b) + 1;
        int endRange = Math.max(a, b) - 1;

        for (int i = startRange; i <= endRange; i++) {
            System.out.print((char)i + " ");
        }
    }
}
