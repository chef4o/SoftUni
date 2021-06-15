package FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String condition = scanner.nextLine();

        List<Integer> output = condition.equals("even")
                ? inputParameters(range).stream().filter(e -> e % 2 == 0).collect(Collectors.toList())
                : inputParameters(range).stream().filter(e -> e % 2 != 0).collect(Collectors.toList());

        System.out.println(output.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public static List<Integer> inputParameters (int[] range) {

        List <Integer> list = new ArrayList<>();
        for (int i = range[0]; i <= range[1]; i++) {
            list.add(i);
        }
        return list;
    }
}
