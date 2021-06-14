package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (counter > 0) {

            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    String input = command[1];
                    stack.push(text.toString());
                    text.append(input);
                    break;
                case "2":
                    stack.push(text.toString());
                    int fromIndex = Integer.parseInt(command[1]);
                    text.delete(text.length() - fromIndex, text.length());
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case "4":
                    if (!stack.isEmpty()) {
                        text = new StringBuilder(stack.pop());
                    }
                    break;
            }

            counter--;
        }
    }
}
