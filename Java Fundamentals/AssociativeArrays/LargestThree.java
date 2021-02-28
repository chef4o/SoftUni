package AssociativeArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .sorted((x, y) -> y.compareTo(x))
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++) {
            if (i > input.size() - 1) {
                break;
            }
            System.out.print(input.get(i) + " ");
        }
    }
}
