package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int interactions = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < interactions; i++) {

            int input = scanner.nextInt();

            if (input == 1) {
                stack.push(scanner.nextInt());
            } else if (input == 2) {
                stack.pop();
            } else if (input == 3) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}