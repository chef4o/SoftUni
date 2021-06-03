package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split("\\s+");
        int step = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String player : players) {
            queue.offer(player);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < step; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.printf("Prime %s\n", queue.peek());
            } else {
                System.out.printf("Removed %s\n", queue.poll());
            }

            cycle++;
        }

        System.out.printf("Last is %s", queue.poll());
    }

    private static boolean isPrime(Integer number) {

        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
