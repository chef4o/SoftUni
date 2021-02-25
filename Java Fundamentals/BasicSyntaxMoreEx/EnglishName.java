package BasicSyntaxMoreEx;

import java.util.Scanner;

public class EnglishName {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();
        String output = null;

        switch (input % 10) {
            case 1:
                output = "one";
                break;
            case 2:
                output = "two";
                break;
            case 3:
                output = "three";
                break;
            case 4:
                output = "four";
                break;
            case 5:
                output = "five";
                break;
            case 6:
                output = "six";
                break;
            case 7:
                output = "seven";
                break;
            case 8:
                output = "eight";
                break;
            case 9:
                output = "nine";
                break;
            case 0:
                output = "zero";
                break;
        }

        System.out.println(output);
    }
}
