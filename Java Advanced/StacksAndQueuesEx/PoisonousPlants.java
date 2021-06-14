package StacksAndQueuesEx;

import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loopSize = scanner.nextInt();
        Deque<Integer> allPlants = new ArrayDeque<>();
        while (loopSize-- > 0) {
            allPlants.offer(scanner.nextInt());
        }
        int daysPassed = 0;

        while (true) {
            Deque<Integer> alivePlants = null;
            boolean deadPlants = false;
            while (dequeIsNotEmpty(allPlants)) {
                int currentPlant = allPlants.pollLast();
                int previousPlant = allPlants.peekLast() != null
                        ? allPlants.peekLast()
                        : -1;
                if (previousPlant != -1 && currentPlant <= previousPlant) {
                    alivePlants = initializeIfEmpty(alivePlants);
                    alivePlants.offerFirst(currentPlant);
                } else if (previousPlant != -1 ) {
                    deadPlants = true;
                }
                if (allPlants.size() == 1) {
                    alivePlants = initializeIfEmpty(alivePlants);
                    alivePlants.offerFirst(previousPlant);
                }
            }
            if (!deadPlants) {
                break;
            } else {
                daysPassed++;
                allPlants = alivePlants;
            }
        }
        System.out.println(daysPassed);
    }

    public static Deque<Integer> initializeIfEmpty (Deque<Integer> deque) {
        return deque == null ? new ArrayDeque<>() : deque;
    }

    public static boolean dequeIsNotEmpty(Deque<Integer> deque) {
        return deque.peekLast() != null;
    }
}
