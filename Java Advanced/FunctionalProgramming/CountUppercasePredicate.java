package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercasePredicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Predicate <String> isUppercase = str -> str != null &&
                                                    !str.isEmpty() &&
                                                    Character.isUpperCase(str.charAt(0));

        List<String> output = Arrays.stream(scanner.nextLine()
                                     .split("\\s+"))
                                     .filter(isUppercase)
                                     .collect(Collectors.toList());

        System.out.println(output.size());
        System.out.println(output.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
