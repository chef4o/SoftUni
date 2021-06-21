package IteratorsAndComparators.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack stack = new CustomStack();

        int[] input = Arrays.stream(scanner.nextLine()
                .split("(\\s+)|(,\\s+)"))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        String command;
        while (!(command = scanner.nextLine()).equals("END")) {
            if (command.equals("Pop")) {
                try {
                    stack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                stack.push(Integer.parseInt(command.split("\\s")[1]));
            }
        }

        for (int i = 0; i < 2; i++) {
            stack.forEach( e -> System.out.println(e));
        }
    }
}
