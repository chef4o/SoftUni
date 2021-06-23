package Bouquets;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> tulipsStack = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));
        Queue<Integer> daffodilsQueue = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int bouquetSize = 15;
        int bouquetsNumber = 0;
        int leftOvers = 0;

        while (!daffodilsQueue.isEmpty() && !tulipsStack.isEmpty()) {

            int currentDaffodils = daffodilsQueue.poll();
            int currentTulips = tulipsStack.pop();

            if (currentDaffodils + currentTulips == 15) {
                bouquetsNumber++;
            } else if (currentDaffodils + currentTulips > 15) {
                while (currentTulips + currentDaffodils > 15) {
                    currentTulips -= 2;
                }

                if (currentTulips + currentDaffodils == 15) {
                    bouquetsNumber++;
                } else {
                    leftOvers += currentDaffodils + currentTulips;
                }
            } else {
                leftOvers += currentDaffodils + currentTulips;
            }
        }

        bouquetsNumber += (leftOvers / 15);

        if (bouquetsNumber >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetsNumber);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetsNumber);
        }

    }
}
