package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean inputIsEqual = true;

        for (Character character : input) {

            switch (character) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || stack.pop() != character) {
                        inputIsEqual = false;
                    }
                    break;
            }

            if (!inputIsEqual) {
                break;
            }
        }

        if (inputIsEqual) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}