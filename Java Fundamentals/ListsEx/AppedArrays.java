package ListsEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine()
                            .split("\\|"))
                            .collect(Collectors.toList());

        List <String> output = new ArrayList<>();

        for (int i = input.size() - 1; i >= 0; i--) {
            output.add(String.join(" ", input.get(i)
                            .split("\\s+")));
        }

        List<String> print = Arrays.stream(output.toString()
                            .replaceAll("[\\[\\],]", "")
                            .split("\\s+"))
                            .collect(Collectors.toList());

        System.out.println(print.toString()
                            .replaceAll("[\\[\\],]", "")
                            .trim());
    }
}
