package DataTypesAndVarsEx;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.Scanner;

public class TripplesOfLetters {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        for (char i = 'a'; i < 'a' + input; i++) {
            for (char j = 'a'; j < 'a' + input ; j++) {
                for (char k = 'a'; k < 'a' + input ; k++) {
                    System.out.printf("%c%c%c%n", (char)i, (char)j, (char)k);
                }
            }
        }
    }
}
