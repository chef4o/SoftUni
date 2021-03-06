package Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        vowelsPrinter(input);
    }

    static void vowelsPrinter(String input) {

        int vowelCount = 0;

        for (int i = 0; i <input.length(); i++) {
            switch (input.charAt(i)) {
                case 'A':
                case 'a':
                case 'E':
                case 'e':
                case 'I':
                case 'i':
                case 'O':
                case 'o':
                case 'U':
                case 'u':
                    vowelCount++;
                    break;
            }
        }

        System.out.println(vowelCount);
   }
}
