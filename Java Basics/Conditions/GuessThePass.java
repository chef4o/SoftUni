package Conditions;

import java.util.Scanner;

public class GuessThePass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String output = null;

        if (password.equals("s3cr3t!P@ssw0rd")) {
            output = "Welcome";
        } else {
            output = "Wrong password!";
        }

        System.out.println(output);
    }
}
