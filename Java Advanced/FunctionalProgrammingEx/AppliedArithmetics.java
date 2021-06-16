package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        Function<int[], int[]> addOne = e -> Arrays.stream(e).map(n -> n += 1).toArray();
        Function<int[], int[]> multiplyByTwo = e -> Arrays.stream(e).map(n -> n *= 2).toArray();
        Function<int[], int[]> subtractOne = e -> Arrays.stream(e).map(n -> n -= 1).toArray();
        Consumer<int[]> printResult = e -> Arrays.stream(e).forEach(n -> System.out.printf("%s ", n));

        String command;
        while (!(command = scanner.nextLine()).equals("end")) {
            switch (command) {
                case "add":
                    input = addOne.apply(input);
                    break;
                case "multiply":
                    input = multiplyByTwo.apply(input);
                    break;
                case "subtract":
                    input = subtractOne.apply(input);
                    break;
                case "print":
                    printResult.accept(input);
                    System.out.println();
                    break;
            }
        }
    }
}
