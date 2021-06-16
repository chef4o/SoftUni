package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Set<Integer> checkNumbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        Predicate<Integer> isDivisible = num -> {
            for (Integer entry : checkNumbers) {
                if (num % entry != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= number; i++) {
            if (isDivisible.test(i)) {
                System.out.printf("%d ", i);
            }
        }
    }
}
