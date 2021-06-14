package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int offerCycles = scanner.nextInt();
        int pollCycles = scanner.nextInt();
        int searchNumber = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < offerCycles; i++) {
            queue.offer(scanner.nextInt());
        }

        for (int j = 0; j < pollCycles; j++) {
            queue.poll();
        }

        if (queue.contains(searchNumber)) {
            System.out.println(true);
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}