package ListsEx;

import java.util.*;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = Arrays.stream(scanner.nextLine()
                .split("\\s +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondHand = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstHand.size() > 0 && secondHand.size() > 0) {

            if (firstHand.get(0) > secondHand.get(0)) {
                firstHand.add((firstHand.get(0)));
                firstHand.add(secondHand.get(0));
            } else if (firstHand.get(0) < secondHand.get(0)) {
                secondHand.add(secondHand.get(0));
                secondHand.add(firstHand.get(0));
            }

            firstHand.remove(0);
            secondHand.remove(0);
        }

        int sum = 0;

        if (firstHand.size() > 0) {
            for (Integer card: firstHand) {
                sum += card;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else if (secondHand.size() > 0) {
            for (Integer card: secondHand) {
                sum += card;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
