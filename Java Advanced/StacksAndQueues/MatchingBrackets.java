package StacksAndQueues;

import java.util.*;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> startIndexes = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '(') {
                startIndexes.push(i);
            }
            if (input.charAt(i) == ')') {
                int endIndex = i;
                System.out.println(input.substring(startIndexes.pop(), endIndex + 1));
            }
        }
    }
}
