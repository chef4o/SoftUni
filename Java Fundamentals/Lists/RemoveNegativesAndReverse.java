package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        input.removeIf(i -> i < 0);

        if (input.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(input);
            System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
