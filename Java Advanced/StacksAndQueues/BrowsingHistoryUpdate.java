package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowsingHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!input.equals("Home")) {

            String currentURL = null;

            if (input.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentURL = stack.pop();
                }
            } else {
                currentURL = scanner.nextLine();
                stack.push(currentURL);
            }

            System.out.println(currentURL);
            input = scanner.nextLine();
        }

    }
}
