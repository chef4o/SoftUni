package Methods;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            System.out.println(palindromeCheck(input));
            input = scanner.nextLine();
        }
    }

    static boolean palindromeCheck (String str) {

        String[] original = str.split("");
        String[] reversed = new String[str.length()];

        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed[i] = original[j];
            j++;
        }

        for (int i = 0; i < original.length; i++) {
            if (!original[i].equals(reversed[i])) {
                return false;
            }
        }

        return true;
    }
}
