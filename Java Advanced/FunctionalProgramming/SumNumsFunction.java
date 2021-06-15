package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumNumsFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, IntStream> getIntStream = str -> Arrays.stream(str.split(",\\s+"))
                                                                            .mapToInt(Integer::parseInt);

        Function<String, Long> count = str -> getIntStream.apply(str).count();
        Function<String, Integer> sum = str -> getIntStream.apply(str).sum();

        System.out.printf("Count = %d%s", count.apply(input), System.lineSeparator());
        System.out.printf("Sum = %d%s", sum.apply(input), System.lineSeparator());
    }
}
