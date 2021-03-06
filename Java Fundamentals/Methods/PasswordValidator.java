package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();

        passwordValidator(input);
    }

    static void passwordValidator(String password) {

        boolean passwordIsValid = true;

        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            passwordIsValid = false;
        }

        int digitCounter = 0;
        boolean digitsAndLettersOnly = true;

        for (int i = 0; i < password.length(); i++) {

            if ((password.charAt(i) < 48 || password.charAt(i) > 122) && digitsAndLettersOnly) {
                System.out.println("Password must consist only of letters and digits");
                digitsAndLettersOnly = false;
                passwordIsValid = false;
            }

            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                digitCounter++;
            }
        }
        if (digitCounter < 2) {
            System.out.println("Password must have at least 2 digits");
            passwordIsValid = false;
        }

        if (passwordIsValid) {
            System.out.println("Password is valid");
        }
    }
}
