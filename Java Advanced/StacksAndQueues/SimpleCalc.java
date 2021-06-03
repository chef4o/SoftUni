package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);

        while (stack.size() > 1) {

            int a = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int b = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+":
                    stack.push(String.valueOf(a + b));
                    break;
                case "-":
                    stack.push(String.valueOf(a - b));
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}
