package BasicSyntaxEx;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        StringBuilder password = new StringBuilder();

        for (int i = username.length() - 1; i >= 0; i--) {
            password.append(username.charAt(i));
        }

        String input = scanner.nextLine();
        int attempts = 1;
        while (!(input.contentEquals(password)) && attempts <= 3) {

            System.out.println("Incorrect password. Try again.");
            attempts++;
            input = scanner.nextLine();
        }

        if (attempts > 3) {
            System.out.printf("User %s blocked!", username);
        } else if (input.contentEquals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
