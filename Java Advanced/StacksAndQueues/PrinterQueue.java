package StacksAndQueues;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s\n", queue.poll());
                    input = scanner.nextLine();
                    continue;
                }
            } else {
                queue.offer(input);
            }

            input = scanner.nextLine();
        }

        while (!queue.isEmpty()) {

            System.out.println(queue.pollFirst());
        }
    }
}
