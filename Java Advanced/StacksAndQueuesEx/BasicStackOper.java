package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pushOperations = scanner.nextInt();
        int popOperations = scanner.nextInt();
        int element = scanner.nextInt();

        int maxElement = Integer.MIN_VALUE;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < pushOperations; i++) {
            stack.push(scanner.nextInt());
        }

        for (int j = 0; j < popOperations; j++) {
            stack.pop();
        }

        boolean elementIsPresent = false;
        for (Integer number : stack) {

            if (stack.peek() > maxElement) {
                maxElement = stack.peek();
            }

            if (number.equals(element)) {
                elementIsPresent = true;
            }
        }

        if (elementIsPresent) {
            System.out.println(elementIsPresent);
        } else {

            if (stack.isEmpty()) {
                maxElement = 0;
            }
            System.out.println(maxElement);
        }
    }
}
