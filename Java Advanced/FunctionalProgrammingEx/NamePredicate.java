package FunctionalProgrammingEx;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NamePredicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filterCondition = Integer.parseInt(scanner.nextLine());
        List<String> input = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> takeNames = name -> name.length() <= filterCondition;
        input.stream().filter(takeNames).forEach(e -> System.out.println(e));
    }
}
