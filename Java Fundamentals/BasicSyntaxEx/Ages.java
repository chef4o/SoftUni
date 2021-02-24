package BasicSyntaxEx;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        String output = null;
        if (input >= 0 && input <= 2) {
            output = "baby";
        } else if (input >= 3 && input <= 13) {
            output = "child";
        } else if (input >= 14 && input <= 19) {
            output = "teenager";
        } else if (input >= 20 && input <= 65) {
            output = "adult";
        } else if (input >= 66) {
            output = "elder";
        }

        System.out.println(output);
    }
}
