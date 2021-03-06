package Methods;

import java.util.Scanner;

public class MiddleChars {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        findMidChars(input);
    }

    static void findMidChars(String str) {

        if (str.length() % 2 == 0) {
            System.out.printf("%c%c", str.charAt(str.length() / 2 - 1), str.charAt(str.length() / 2));
        } else {
            System.out.printf("%c", str.charAt(str.length() / 2) );
        }
    }
}
