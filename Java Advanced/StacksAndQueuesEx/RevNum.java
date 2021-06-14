package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RevNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        for (String s : stack) {
            System.out.printf("%s ", stack.pop());
        }
    }
}