package FunctionalProgrammingEx;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine()
                             .split("\\s+"))
                             .map(Integer::parseInt)
                             .collect(Collectors.toList());

        int divisor = Integer.parseInt(scanner.nextLine());
        Collections.reverse(input);
        Predicate<Integer> ifDividable = e -> e % divisor != 0;
        input.stream().filter(ifDividable).forEach(n -> System.out.printf("%s ", n));
    }
}
