package Task1;

import java.util.*;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> box1queue = Arrays.stream(scanner.nextLine()
                                                        .split("\\s+"))
                                                        .map(Integer::parseInt)
                                                        .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> box2queue = Arrays.stream(scanner.nextLine()
                                                        .split("\\s+"))
                                                        .map(Integer::parseInt)
                                                        .collect(Collectors.toCollection(ArrayDeque::new));

        int qualityItems = 0;

        while (!box1queue.isEmpty() && !box2queue.isEmpty()) {

            int num1 = box1queue.peekFirst();
            int num2 = box2queue.peekLast();

            if ((num1 + num2) % 2 == 0) {
                qualityItems += box1queue.pollFirst() + box2queue.pollLast();
            } else {
                box1queue.offerLast(box2queue.pollLast());
            }
        }

        if (box1queue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (box2queue.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (qualityItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d\n", qualityItems);
        } else {
            System.out.printf("Poor prey... Value: %d", qualityItems);
        }
    }
}
