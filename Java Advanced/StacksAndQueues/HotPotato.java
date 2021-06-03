package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split("\\s+");
        int steps = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String s : players) {
            queue.offer(s);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < steps; i++) {

                queue.offer(queue.poll());
            }

            System.out.printf("Removed %s\n", queue.poll());
        }

        System.out.printf("Last is %s\n", queue.poll());
    }
}
